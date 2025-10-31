package com.example.animals.services.service

import com.example.animals.data.dto.login.LoginRequestDto
import com.example.animals.data.dto.login.LoginResponseDto
import java.util.UUID

interface AuthService {
    fun login(request: LoginRequestDto): LoginResponseDto

    fun logAuthenticationActivity(uuid: UUID?, action: String)
}