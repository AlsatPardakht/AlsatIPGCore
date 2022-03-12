package com.alsatpardakht.alsatipgcore.data.remote.dto

import com.alsatpardakht.alsatipgcore.domain.model.PaymentType
import com.alsatpardakht.alsatipgcore.domain.model.TashimModel
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

data class PaymentSignRequest(
    var Api: String,
    var Amount: String,
    var InvoiceNumber: String,
    var RedirectAddress: String,
    var Type: PaymentType = PaymentType.Mostaghim,
    var Tashim: List<TashimModel> = mutableListOf()
)

fun List<TashimModel>.toJson(): String {
    return Json.encodeToJsonElement(this).toString()
}