package com.alsatpardakht.alsatipgcore.data.repository

import com.alsatpardakht.alsatipgcore.core.util.Resource
import com.alsatpardakht.alsatipgcore.data.remote.IPGService
import com.alsatpardakht.alsatipgcore.data.remote.model.*
import com.alsatpardakht.alsatipgcore.data.remote.util.PaymentSignRequestType
import com.alsatpardakht.alsatipgcore.domain.repository.IPGRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class IPGRepositoryImpl(
    private val iPGService: IPGService
) : IPGRepository {

    override fun sign(paymentSignRequest: PaymentSignRequest): Flow<Resource<PaymentSignResponse>> =
        flow {
            emit(Resource.Loading)
            val result = try {
                when (paymentSignRequest.Type) {
                    PaymentSignRequestType.Mostaghim -> {
                        iPGService.signMostaghim(paymentSignRequest)
                    }
                    PaymentSignRequestType.Vaset -> {
                        iPGService.signVaset(paymentSignRequest)
                    }
                    else -> {
                        emit(Resource.Error(Exception("payment sign request type is not valid")))
                        return@flow
                    }
                }
            } catch (exception: Exception) {
                emit(Resource.Error(exception))
                return@flow
            }
            if (result.Sign == null || result.Sign.isEmpty() || result.Token == null || result.Token.isEmpty()) {
                emit(
                    Resource.Error(
                        Exception("payment not successful! sign or token is null"),
                        result
                    )
                )
                return@flow
            }
            emit(Resource.Success(result))
        }

    override fun validation(paymentValidationRequest: PaymentValidationRequest): Flow<Resource<PaymentValidationResponse>> =
        flow {
            emit(Resource.Loading)
            val resultJson = try {
                iPGService.validationMostaghim(paymentValidationRequest)
            } catch (exception: Exception) {
                emit(Resource.Error(exception))
                return@flow
            }
            if (resultJson == null || resultJson.isEmpty() || resultJson.length < 20) {
                emit(Resource.Error(Exception("payment not valid!")))
                return@flow
            }
            val result = try {
                resultJson.toPaymentValidationResponse()
            } catch (exception: Exception) {
                emit(Resource.Error(exception))
                return@flow
            }
            emit(Resource.Success(result))
        }
}