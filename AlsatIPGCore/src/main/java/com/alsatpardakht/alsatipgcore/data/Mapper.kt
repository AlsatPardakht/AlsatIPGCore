package com.alsatpardakht.alsatipgcore.data

interface Mapper<T> {
    fun toDomainModel(): T
}