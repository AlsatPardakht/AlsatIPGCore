package com.alsatpardakht.alsatipgcore.domain.use_case

import com.alsatpardakht.alsatipgcore.core.util.Resource
import com.alsatpardakht.alsatipgcore.data.remote.model.PaymentValidationRequest
import com.alsatpardakht.alsatipgcore.data.remote.model.PaymentValidationResponse
import com.alsatpardakht.alsatipgcore.domain.repository.IPGRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PaymentValidationUseCase(
    private val iPGRepository: IPGRepository
) {
    fun execute(paymentValidationRequest: PaymentValidationRequest): Flow<Resource<PaymentValidationResponse>> {
        return when {
            paymentValidationRequest.Api.isEmpty() -> error(
                "error in PaymentValidationRequest.Api value ! \n" +
                        "this field should not be empty"
            )
            paymentValidationRequest.iD == null || paymentValidationRequest.iD?.isEmpty() ?: true -> error(
                "error in PaymentValidationRequest.iD value ! \n" +
                        "this field should not be empty"
            )
            paymentValidationRequest.iN == null || paymentValidationRequest.iN?.isEmpty() ?: true -> error(
                "error in PaymentValidationRequest.iN value ! \n" +
                        "this field should not be empty"
            )
            paymentValidationRequest.tref == null || paymentValidationRequest.tref?.isEmpty() ?: true -> error(
                "error in PaymentValidationRequest.tref value ! \n" +
                        "this field should not be empty"
            )
            else -> iPGRepository.validation(paymentValidationRequest)
        }
    }

    private fun error(message: String) = flow {
        emit(Resource.Error<PaymentValidationResponse>(Exception(message)))
    }
}