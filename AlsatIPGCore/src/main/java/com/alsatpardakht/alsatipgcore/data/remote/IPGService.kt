package com.alsatpardakht.alsatipgcore.data.remote

import com.alsatpardakht.alsatipgcore.data.remote.model.PaymentValidationRequest
import com.alsatpardakht.alsatipgcore.data.remote.model.PaymentSignRequest
import com.alsatpardakht.alsatipgcore.data.remote.model.PaymentSignResponse

interface IPGService {
    suspend fun signMostaghim(paymentSignRequest: PaymentSignRequest): PaymentSignResponse
    suspend fun signVaset(paymentSignRequest: PaymentSignRequest): PaymentSignResponse
    suspend fun validationMostaghim(paymentValidationRequest: PaymentValidationRequest): String?
    suspend fun validationVaset(paymentValidationRequest: PaymentValidationRequest): String?
}