package com.example.animals.data.dto.user

import java.time.LocalDateTime

data class UserLoginResponseDto(
    val uuid: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String,
    val createdAt: LocalDateTime,
)
