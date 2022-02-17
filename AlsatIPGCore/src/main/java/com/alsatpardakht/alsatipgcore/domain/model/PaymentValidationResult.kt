package com.alsatpardakht.alsatipgcore.domain.model

import com.alsatpardakht.alsatipgcore.data.remote.model.PaymentValidationResponse

data class PaymentValidationResult(
    val isLoading: Boolean = false,
    val isSuccessful: Boolean = false,
    val error: Throwable? = null,
    val data: PaymentValidationResponse? = null
)