package com.alsatpardakht.alsatipgcore.domain.model

import com.alsatpardakht.alsatipgcore.data.remote.model.PaymentValidationResponse

data class PaymentValidationResult(
    val isLoading: Boolean = false,
    val isSuccessful: Boolean = false,
    val error: Exception? = null,
    val data: PaymentValidationResponse? = null
)