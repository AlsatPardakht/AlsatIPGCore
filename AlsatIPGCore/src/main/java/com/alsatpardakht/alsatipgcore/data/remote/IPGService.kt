package com.alsatpardakht.alsatipgcore.data.remote

import com.alsatpardakht.alsatipgcore.data.remote.dto.PaymentValidationRequest
import com.alsatpardakht.alsatipgcore.data.remote.dto.PaymentSignRequest
import com.alsatpardakht.alsatipgcore.data.remote.dto.PaymentSignResponse
import com.alsatpardakht.alsatipgcore.data.remote.dto.PaymentValidationResponse

interface IPGService {
    suspend fun signMostaghim(paymentSignRequest: PaymentSignRequest): PaymentSignResponse
    suspend fun signVaset(paymentSignRequest: PaymentSignRequest): PaymentSignResponse
    suspend fun validationMostaghim(paymentValidationRequest: PaymentValidationRequest): PaymentValidationResponse
    suspend fun validationVaset(paymentValidationRequest: PaymentValidationRequest): PaymentValidationResponse
}