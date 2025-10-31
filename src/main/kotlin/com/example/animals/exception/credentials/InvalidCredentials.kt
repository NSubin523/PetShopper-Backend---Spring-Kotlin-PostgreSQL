package com.example.animals.exception.credentials

import com.example.animals.exception.base.ResourceException


class InvalidCredentialsException(
    fieldName: String = "credentials",
    fieldValue: String = "invalid"
) : ResourceException(
    message = "Invalid $fieldName provided.",
    resourceName = "User",
    fieldName = fieldName,
    fieldValue = fieldValue
)