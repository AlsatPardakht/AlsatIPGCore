package com.alsatpardakht.alsatipgcore.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class VERIFY(
    val HashedCardNumber: String,
    val IsSuccess: Boolean,
    val MaskedCardNumber: String,
    val Message: String,
    val ShaparakRefNumber: String
)