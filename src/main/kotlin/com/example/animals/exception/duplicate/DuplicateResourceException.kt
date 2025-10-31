package com.example.animals.exception.duplicate

import com.example.animals.exception.base.ResourceException

class DuplicateResourceException(
    resourceName: String,
    fieldName: String,
    fieldValue: String
) : ResourceException(
    message = "$resourceName with $fieldName '$fieldValue' already exists.",
    resourceName = resourceName,
    fieldName = fieldName,
    fieldValue = fieldValue
)