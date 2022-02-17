package com.alsatpardakht.alsatipgcore.data.remote.model

data class PaymentValidationRequest(
    var Api: String,
    var tref: String? = null,
    var iN: String? = null,
    var iD: String? = null
)