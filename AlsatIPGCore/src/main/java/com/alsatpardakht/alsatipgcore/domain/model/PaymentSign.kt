package com.alsatpardakht.alsatipgcore.domain.model

data class PaymentSign(
    val InvoiceDate: String,
    val IsSuccess: Int,
    val Sign: String,
    val TimeStamp: String,
    val Token: String
)