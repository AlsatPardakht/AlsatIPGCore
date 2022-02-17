package com.alsatpardakht.alsatipgcore.data.remote.util

fun String.appendPath(path: String) = "$this/$path"


fun String.appendQuery(queryKey: String, queryValue: String) =
    buildString {
        append(this@appendQuery)
        append(
            if (!this.contains("?")) "?"
            else "&"
        )
        append("$queryKey=$queryValue")
    }

