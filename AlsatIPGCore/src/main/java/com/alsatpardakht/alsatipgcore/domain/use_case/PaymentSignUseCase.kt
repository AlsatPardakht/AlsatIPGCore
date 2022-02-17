package com.alsatpardakht.alsatipgcore.domain.use_case

import com.alsatpardakht.alsatipgcore.core.util.Constant.MIN_PAYMENT_AMOUNT
import com.alsatpardakht.alsatipgcore.core.util.Resource
import com.alsatpardakht.alsatipgcore.data.remote.model.PaymentSignRequest
import com.alsatpardakht.alsatipgcore.data.remote.util.PaymentSignRequestType
import com.alsatpardakht.alsatipgcore.data.remote.model.PaymentSignResponse
import com.alsatpardakht.alsatipgcore.domain.repository.IPGRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PaymentSignUseCase(
    private val iPGRepository: IPGRepository
) {
    fun execute(paymentSignRequest: PaymentSignRequest): Flow<Resource<PaymentSignResponse>> {
        return when {
            paymentSignRequest.Amount < MIN_PAYMENT_AMOUNT -> error(
                "error in PaymentSignRequest.Amount value ! \n" +
                        "The minimum amount payable is $MIN_PAYMENT_AMOUNT" +
                        "You have entered ${paymentSignRequest.Amount}"
            )
            paymentSignRequest.Api.isEmpty() -> error(
                "error in PaymentSignRequest.Api value ! \n" +
                        "this field should not be empty"
            )
            paymentSignRequest.Type == PaymentSignRequestType.Mostaghim &&
                    paymentSignRequest.InvoiceNumber.isEmpty() -> error(
                "error in PaymentSignRequest.InvoiceNumber value ! \n" +
                        "this field should not be empty"
            )
            paymentSignRequest.Type == PaymentSignRequestType.Vaset &&
                    paymentSignRequest.Tashim.isEmpty() -> error(
                "error in PaymentSignRequest.Tashim value ! \n" +
                        "this field should not be empty"
            )
            paymentSignRequest.RedirectAddress.isEmpty() -> error(
                "error in PaymentSignRequest.RedirectAddress value ! \n" +
                        "this field should not be empty"
            )
            else -> iPGRepository.sign(paymentSignRequest)
        }
    }

    private fun error(message: String) = flow {
        emit(Resource.Error<PaymentSignResponse>(Throwable(message)))
    }
}