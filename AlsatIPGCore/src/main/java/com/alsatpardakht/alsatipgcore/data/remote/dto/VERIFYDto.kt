package com.alsatpardakht.alsatipgcore.data.remote.dto

import com.alsatpardakht.alsatipgcore.data.Mapper
import com.alsatpardakht.alsatipgcore.domain.model.VERIFY
import kotlinx.serialization.Serializable

@Serializable
data class VERIFYDto(
    val HashedCardNumber: String?,
    val IsSuccess: Boolean?,
    val MaskedCardNumber: String?,
    val Message: String?,
    val ShaparakRefNumber: String?
) : Mapper<VERIFY> {

    override fun toDomainModel(): VERIFY {
        return VERIFY(
            HashedCardNumber = HashedCardNumber!!,
            IsSuccess = IsSuccess!!,
            MaskedCardNumber = MaskedCardNumber!!,
            Message = Message!!,
            ShaparakRefNumber = ShaparakRefNumber!!
        )
    }
}