package com.alsatpardakht.alsatipgcore.domain.model

data class PaymentValidationResult(
    val isLoading: Boolean = false,
    val isSuccessful: Boolean = false,
    val error: Exception? = null,
    val data: PaymentValidation? = null
)