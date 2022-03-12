package com.alsatpardakht.alsatipgcore.domain.use_case

import com.alsatpardakht.alsatipgcore.core.util.Resource
import com.alsatpardakht.alsatipgcore.domain.model.PaymentType
import com.alsatpardakht.alsatipgcore.domain.model.PaymentValidation
import com.alsatpardakht.alsatipgcore.domain.repository.IPGRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PaymentValidationUseCase(
    private val iPGRepository: IPGRepository
) {
    fun execute(
        tref: String?,
        iN: String?,
        iD: String?,
        Api: String = "",
        Type: PaymentType = PaymentType.Mostaghim
    ): Flow<Resource<PaymentValidation>> {
        return when {
            Type == PaymentType.Mostaghim && Api.isEmpty() -> error(
                "error in Api value ! \n" +
                        "this field should not be empty in paymentType " + PaymentType.Mostaghim
            )
            iD == null || iD.isEmpty() -> error(
                "error in iD value ! \n" +
                        "this field should not be empty"
            )
            iN == null || iN.isEmpty() -> error(
                "error in iN value ! \n" +
                        "this field should not be empty"
            )
            tref == null || tref.isEmpty() -> error(
                "error in tref value ! \n" +
                        "this field should not be empty"
            )
            else -> iPGRepository.validation(tref, iN, iD, Api, Type)
        }
    }

    private fun error(message: String) = flow {
        emit(Resource.Error<PaymentValidation>(Exception(message)))
    }
}