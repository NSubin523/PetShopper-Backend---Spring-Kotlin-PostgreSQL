package com.example.animals.exception.invalid

import com.example.animals.exception.base.ResourceException

class CategoryNotFoundException(
    resourceName: String,
    fieldName: String,
    fieldValue: String
): ResourceException(
    message = "$resourceName with $fieldName '$fieldValue' was not found.",
    resourceName = resourceName,
    fieldName = fieldName,
    fieldValue = fieldValue
)