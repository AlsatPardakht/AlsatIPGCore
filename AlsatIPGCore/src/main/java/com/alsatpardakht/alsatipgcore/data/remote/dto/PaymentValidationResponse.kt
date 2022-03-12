package com.alsatpardakht.alsatipgcore.data.remote.dto

import com.alsatpardakht.alsatipgcore.data.Mapper
import com.alsatpardakht.alsatipgcore.domain.model.PaymentValidation
import kotlinx.serialization.Serializable

@Serializable
data class PaymentValidationResponse(
    val PSP: PSPDto,
    val VERIFY: VERIFYDto
) : Mapper<PaymentValidation> {

    override fun toDomainModel(): PaymentValidation {
        return PaymentValidation(
            PSP = PSP.toDomainModel(),
            VERIFY = VERIFY.toDomainModel()
        )
    }
}