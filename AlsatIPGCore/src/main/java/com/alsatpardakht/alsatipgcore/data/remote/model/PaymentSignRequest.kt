package com.alsatpardakht.alsatipgcore.data.remote.model

import com.alsatpardakht.alsatipgcore.data.remote.util.PaymentSignRequestType
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

data class PaymentSignRequest(
    var Api: String,
    var Amount: String,
    var InvoiceNumber: String,
    var RedirectAddress: String
) {
    var Type = PaymentSignRequestType.Mostaghim
    var Tashim: MutableList<TashimModel> = mutableListOf()
}

fun MutableList<TashimModel>.toJson(): String {
    return Json.encodeToJsonElement(this).toString()
}