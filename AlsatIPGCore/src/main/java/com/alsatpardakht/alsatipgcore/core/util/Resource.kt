package com.alsatpardakht.alsatipgcore.core.util

sealed class Resource<R> {
    class Success<T>(val data: T) : Resource<T>()
    class Error<T>(val error: Exception, val data: T? = null) : Resource<T>()
    class Loading<T> : Resource<T>()
}
