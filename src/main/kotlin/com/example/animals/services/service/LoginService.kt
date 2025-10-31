package com.example.animals.services.service

import com.example.animals.data.dto.login.LoginRequestDto
import com.example.animals.data.dto.login.LoginResponseDto

interface LoginService {
    fun login(request: LoginRequestDto): LoginResponseDto
}