package com.example.animals.data.dto.activity

import java.util.UUID

data class AuthActivityDto(
    val userUuid: UUID? = null,
    val action: String
)
