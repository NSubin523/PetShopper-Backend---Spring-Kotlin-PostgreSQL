package com.example.animals.data.dto.user

import jakarta.validation.constraints.*

data class CreateUserRequestDto(
    @field:NotBlank(message = "First Name cannot be blank")
    @field:Pattern(regexp = "^[A-Za-z]+$", message = "First name must contain only letters")
    val firstName: String,

    @field:NotBlank(message = "First Name cannot be blank")
    @field:Pattern(regexp = "^[A-Za-z]+$", message = "First name must contain only letters")
    val lastName: String,

    @field:Email(message = "Invalid email format")
    val email: String,

    @field:Size(min = 8, message = "Password must be at least 8 characters long")
    val password: String,

    @field:Pattern(regexp = "^[0-9]{10,15}$", message = "Phone number must be 10–15 digits")
    val phoneNumber: String
)
