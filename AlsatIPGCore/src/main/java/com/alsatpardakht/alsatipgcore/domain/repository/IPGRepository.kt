package com.alsatpardakht.alsatipgcore.domain.repository

import com.alsatpardakht.alsatipgcore.core.util.Resource
import com.alsatpardakht.alsatipgcore.domain.model.PaymentType
import com.alsatpardakht.alsatipgcore.domain.model.PaymentSign
import com.alsatpardakht.alsatipgcore.domain.model.PaymentValidation
import com.alsatpardakht.alsatipgcore.domain.model.TashimModel
import kotlinx.coroutines.flow.Flow

interface IPGRepository {
    fun sign(
        Api: String,
        Amount: String,
        InvoiceNumber: String,
        RedirectAddress: String,
        Type: PaymentType,
        Tashim: List<TashimModel>
    ): Flow<Resource<PaymentSign>>

    fun validation(
        tref: String,
        iN: String,
        iD: String,
        Api: String,
        Type: PaymentType
    ): Flow<Resource<PaymentValidation>>
}