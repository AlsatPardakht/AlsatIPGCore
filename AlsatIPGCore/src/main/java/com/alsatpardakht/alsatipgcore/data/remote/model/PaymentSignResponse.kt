package com.alsatpardakht.alsatipgcore.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class PaymentSignResponse(
    val InvoiceDate: String,
    val IsSuccess: Int,
    val Sign: String?,
    val TimeStamp: String,
    val Token: String?
)