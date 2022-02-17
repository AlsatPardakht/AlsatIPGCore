package com.alsatpardakht.alsatipgcore.data.remote.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString

@Serializable
data class PaymentValidationResponse(
    val PSP: PSP,
    val VERIFY: VERIFY
)

fun String.toPaymentValidationResponse(): PaymentValidationResponse {
    return Json.decodeFromString(this)
}