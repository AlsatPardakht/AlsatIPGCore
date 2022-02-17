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
                        emit(Resource.Error(Throwable("payment sign request type is not valid")))
                        return@flow
                    }
                }
            } catch (throwable: Throwable) {
                emit(Resource.Error(throwable))
                return@flow
            }
            if (result.Sign == null || result.Sign.isEmpty() || result.Token == null || result.Token.isEmpty()) {
                emit(
                    Resource.Error(
                        Throwable("payment not successful! sign or token is null"),
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
            } catch (throwable: Throwable) {
                emit(Resource.Error(throwable))
                return@flow
            }
            if (resultJson == null || resultJson.isEmpty() || resultJson.length < 20) {
                emit(Resource.Error(Throwable("payment not valid!")))
                return@flow
            }
            val result = try {
                resultJson.toPaymentValidationResponse()
            } catch (throwable: Throwable) {
                emit(Resource.Error(throwable))
                return@flow
            }
            emit(Resource.Success(result))
        }
}