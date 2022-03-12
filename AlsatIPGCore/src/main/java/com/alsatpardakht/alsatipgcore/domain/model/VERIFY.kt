package com.alsatpardakht.alsatipgcore.domain.model

data class VERIFY(
    val HashedCardNumber: String,
    val IsSuccess: Boolean,
    val MaskedCardNumber: String,
    val Message: String,
    val ShaparakRefNumber: String
)
