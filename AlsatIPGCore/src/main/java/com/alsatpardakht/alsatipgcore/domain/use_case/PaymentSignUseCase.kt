package com.alsatpardakht.alsatipgcore.domain.use_case

import com.alsatpardakht.alsatipgcore.core.util.Constant.MAX_PAYMENT_AMOUNT
import com.alsatpardakht.alsatipgcore.core.util.Constant.MIN_PAYMENT_AMOUNT_MOSTAGHIM
import com.alsatpardakht.alsatipgcore.core.util.Constant.MIN_PAYMENT_AMOUNT_VASET
import com.alsatpardakht.alsatipgcore.core.util.Resource
import com.alsatpardakht.alsatipgcore.domain.model.PaymentType
import com.alsatpardakht.alsatipgcore.domain.model.TashimModel
import com.alsatpardakht.alsatipgcore.domain.model.PaymentSign
import com.alsatpardakht.alsatipgcore.domain.repository.IPGRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PaymentSignUseCase(
    private val iPGRepository: IPGRepository
) {
    fun execute(
        Amount: Long,
        Api: String,
        InvoiceNumber: String,
        RedirectAddress: String,
        Type: PaymentType,
        Tashim: List<TashimModel>
    ): Flow<Resource<PaymentSign>> {
        return when {
            Type == PaymentType.Vaset && Amount < MIN_PAYMENT_AMOUNT_VASET -> error(
                "error in Amount value ! \n" +
                        "The minimum amount payable is $MIN_PAYMENT_AMOUNT_VASET" +
                        " You have entered $Amount"
            )
            Type == PaymentType.Mostaghim && Amount < MIN_PAYMENT_AMOUNT_MOSTAGHIM -> error(
                "error in Amount value ! \n" +
                        "The minimum amount payable is $MIN_PAYMENT_AMOUNT_VASET" +
                        " You have entered $Amount"
            )
            Amount > MAX_PAYMENT_AMOUNT -> error(
                "error in Amount value ! \n" +
                        "The maximum amount payable is $MAX_PAYMENT_AMOUNT" +
                        " You have entered $Amount"
            )
            Api.isBlank() -> error(
                "error in Api value ! \n" +
                        "this field should not be empty"
            )
            Type == PaymentType.Mostaghim && InvoiceNumber.isBlank() -> error(
                "error in InvoiceNumber value ! \n" +
                        "this field should not be empty"
            )
            RedirectAddress.isBlank() -> error(
                "error in RedirectAddress value ! \n" +
                        "this field should not be empty"
            )
            else -> iPGRepository.sign(
                Amount = Amount.toString(),
                Api = Api,
                Type = Type,
                InvoiceNumber = InvoiceNumber,
                RedirectAddress = RedirectAddress,
                Tashim = Tashim
            )
        }
    }

    private fun error(message: String) = flow {
        emit(Resource.Error<PaymentSign>(Exception(message)))
    }
}
