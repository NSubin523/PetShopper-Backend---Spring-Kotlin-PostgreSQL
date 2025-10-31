package com.example.animals.exception

import com.example.animals.exception.credentials.InvalidCredentialsException
import com.example.animals.exception.duplicate.DuplicateResourceException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResourceException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun handleDuplicateResource(ex: DuplicateResourceException): ResponseEntity<Map<String, Any>> {
        val body = mapOf(
            "error" to "Duplicate Resource",
            "message" to ex.message,
            "resource" to ex.resourceName,
            "field" to ex.fieldName,
            "value" to ex.fieldValue,
            "status" to HttpStatus.CONFLICT.value()
        )
        return ResponseEntity(body, HttpStatus.CONFLICT)
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleGenericError(ex: Exception): ResponseEntity<Map<String, Any>> {
        val body = mapOf(
            "error" to "Internal Server Error",
            "message" to ex.localizedMessage,
            "status" to HttpStatus.INTERNAL_SERVER_ERROR.value()
        )
        return ResponseEntity(body, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException::class)
    fun handleValidationErrors(ex: org.springframework.web.bind.MethodArgumentNotValidException)
            : ResponseEntity<Map<String, Any>> {

        val errors = ex.bindingResult.fieldErrors.associate { error ->
            error.field to (error.defaultMessage ?: "Invalid value")
        }

        val body = mapOf(
            "error" to "Validation Error",
            "message" to "Invalid request payload",
            "fields" to errors,
            "status" to HttpStatus.BAD_REQUEST.value()
        )

        return ResponseEntity(body, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(InvalidCredentialsException::class)
    fun handleInvalidCredentials(ex: InvalidCredentialsException): ResponseEntity<Map<String, Any>> {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(
                mapOf(
                    "status" to HttpStatus.UNAUTHORIZED.value(),
                    "error" to "Unauthorized",
                    "message" to ex.message
                )
            )
    }

}
