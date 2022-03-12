package com.alsatpardakht.alsatipgcore.data.remote.dto

import com.alsatpardakht.alsatipgcore.domain.model.PaymentType

data class PaymentValidationRequest(
    var tref: String,
    var iN: String,
    var iD: String,
    var Api: String = "",
    var Type: PaymentType
)