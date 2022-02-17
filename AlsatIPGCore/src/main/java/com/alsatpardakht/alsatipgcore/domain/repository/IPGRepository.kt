package com.alsatpardakht.alsatipgcore.domain.repository

import com.alsatpardakht.alsatipgcore.core.util.Resource
import com.alsatpardakht.alsatipgcore.data.remote.model.PaymentSignRequest
import com.alsatpardakht.alsatipgcore.data.remote.model.PaymentValidationRequest
import com.alsatpardakht.alsatipgcore.data.remote.model.PaymentValidationResponse
import com.alsatpardakht.alsatipgcore.data.remote.model.PaymentSignResponse
import kotlinx.coroutines.flow.Flow

interface IPGRepository {
    fun sign(paymentSignRequest: PaymentSignRequest): Flow<Resource<PaymentSignResponse>>
    fun validation(paymentValidationRequest: PaymentValidationRequest): Flow<Resource<PaymentValidationResponse>>
}