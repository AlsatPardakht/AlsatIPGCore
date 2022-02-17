package com.alsatpardakht.alsatipgcore.domain.model

data class PaymentSignResult(
    val isLoading: Boolean = false,
    val isSuccessful: Boolean = false,
    val error: Throwable? = null,
    val url: String? = null
)