package com.example.animals.data.dto.activity

import java.util.UUID

data class LoginLogoutActivityDto(
    val userUuid: UUID? = null,
    val action: String
)
