package com.alsatpardakht.alsatipgcore.data.repository

import com.alsatpardakht.alsatipgcore.core.util.Resource
import com.alsatpardakht.alsatipgcore.data.remote.IPGService
import com.alsatpardakht.alsatipgcore.data.remote.dto.*
import com.alsatpardakht.alsatipgcore.domain.model.PaymentType
import com.alsatpardakht.alsatipgcore.domain.model.PaymentSign
import com.alsatpardakht.alsatipgcore.domain.model.PaymentValidation
import com.alsatpardakht.alsatipgcore.domain.model.TashimModel
import com.alsatpardakht.alsatipgcore.domain.repository.IPGRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class IPGRepositoryImpl(
    private val iPGService: IPGService
) : IPGRepository {

    override fun sign(
        Api: String,
        Amount: String,
        InvoiceNumber: String,
        RedirectAddress: String,
        Type: PaymentType,
        Tashim: List<TashimModel>
    ): Flow<Resource<PaymentSign>> = flow {
        emit(Resource.Loading())
        val request = PaymentSignRequest(
            Api = Api,
            Amount = Amount,
            InvoiceNumber = InvoiceNumber,
            RedirectAddress = RedirectAddress,
            Type = Type,
            Tashim = Tashim
        )
        val responseDto = try {
            when (Type) {
                PaymentType.Mostaghim -> iPGService.signMostaghim(request)
                PaymentType.Vaset -> iPGService.signVaset(request)
            }
        } catch (exception: Exception) {
            emit(Resource.Error(exception))
            return@flow
        }
        val response = try {
            responseDto.toDomainModel()
        } catch (exception: Exception) {
            emit(Resource.Error(RuntimeException("payment sign not successful! sign or token is null")))
            return@flow
        }
        emit(Resource.Success(response))
    }

    override fun validation(
        tref: String,
        iN: String,
        iD: String,
        Api: String,
        Type: PaymentType
    ): Flow<Resource<PaymentValidation>> = flow {
        emit(Resource.Loading())
        val request = PaymentValidationRequest(
            tref = tref,
            iN = iN,
            iD = iD,
            Api = Api,
            Type = Type
        )
        val responseDto = try {
            when (Type) {
                PaymentType.Mostaghim -> iPGService.validationMostaghim(request)
                PaymentType.Vaset -> iPGService.validationVaset(request)
            }
        } catch (exception: Exception) {
            emit(Resource.Error(exception))
            return@flow
        }
        val response = try {
            responseDto.toDomainModel()
        } catch (exception: Exception) {
            emit(Resource.Error(RuntimeException("error payment not valid")))
            return@flow
        }
        emit(Resource.Success(response))
    }
}