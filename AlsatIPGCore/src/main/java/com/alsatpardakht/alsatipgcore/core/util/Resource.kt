package com.alsatpardakht.alsatipgcore.core.util

sealed class Resource<out R> {
    class Success<out T>(val data: T) : Resource<T>()
    class Error<out T>(val error: Exception, val data: T? = null) : Resource<T>()
    object Loading : Resource<Nothing>()
}
