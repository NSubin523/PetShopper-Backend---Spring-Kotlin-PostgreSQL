package com.example.animals.exception.base

open class ResourceException(
    override val message: String,
    val resourceName: String,
    val fieldName: String,
    val fieldValue: String
) : RuntimeException(message)