package com.alsatpardakht.alsatipgcore.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class TashimModel(
    val CodeMelli: String,
    val Family: String,
    val Name: String,
    val Price: String,
    val Shaba: String
)