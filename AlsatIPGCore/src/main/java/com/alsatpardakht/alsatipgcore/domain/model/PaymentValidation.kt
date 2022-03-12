package com.alsatpardakht.alsatipgcore.domain.model

data class PaymentValidation(
    val PSP: PSP,
    val VERIFY: VERIFY,
    var PayId: String? = null
)
