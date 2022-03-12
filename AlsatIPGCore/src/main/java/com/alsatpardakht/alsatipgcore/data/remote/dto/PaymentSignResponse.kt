package com.alsatpardakht.alsatipgcore.data.remote.dto

import com.alsatpardakht.alsatipgcore.data.Mapper
import com.alsatpardakht.alsatipgcore.domain.model.PaymentSign
import kotlinx.serialization.Serializable

@Serializable
data class PaymentSignResponse(
    val InvoiceDate: String,
    val IsSuccess: Int,
    val Sign: String?,
    val TimeStamp: String,
    val Token: String?
) : Mapper<PaymentSign> {

    override fun toDomainModel(): PaymentSign {
        return PaymentSign(
            InvoiceDate = InvoiceDate,
            IsSuccess = IsSuccess,
            Sign = Sign!!,
            TimeStamp = TimeStamp,
            Token = Token!!
        )
    }
}