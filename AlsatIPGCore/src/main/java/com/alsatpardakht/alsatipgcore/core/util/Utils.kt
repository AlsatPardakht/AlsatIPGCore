package com.alsatpardakht.alsatipgcore.core.util

import java.net.URLDecoder

fun String.decodeQueryParameter(): String =
    URLDecoder.decode(
        this,
        "ASCII"
    )
