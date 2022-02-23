package com.alsatpardakht.alsatipgcore.domain.model

data class PaymentSignResult(
    val isLoading: Boolean = false,
    val isSuccessful: Boolean = false,
    val error: Exception? = null,
    val url: String? = null
)