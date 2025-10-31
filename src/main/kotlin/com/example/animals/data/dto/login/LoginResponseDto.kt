package com.example.animals.data.dto.login

import com.example.animals.data.dto.user.UserLoginResponseDto

data class LoginResponseDto(
    val user: UserLoginResponseDto,
    val jwtToken: String,
    val refreshToken: String?
)
