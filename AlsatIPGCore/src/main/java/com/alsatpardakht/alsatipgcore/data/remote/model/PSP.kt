package com.alsatpardakht.alsatipgcore.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class PSP(
    val Amount: Int,
    val InvoiceDate: String,
    val InvoiceNumber: String,
    val IsSuccess: Boolean,
    val MerchantCode: Int,
    val Message: String,
    val ReferenceNumber: Long,
    val TerminalCode: Int,
    val TraceNumber: Int,
    val TransactionDate: String,
    val TransactionReferenceID: String,
    val TrxHashedCardNumber: String,
    val TrxMaskedCardNumber: String
)