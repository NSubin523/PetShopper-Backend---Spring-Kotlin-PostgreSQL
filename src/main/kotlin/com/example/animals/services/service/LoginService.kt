package com.example.animals.services.service

import com.example.animals.data.dto.activity.LoginLogoutActivityDto
import com.example.animals.data.dto.login.LoginRequestDto
import com.example.animals.data.dto.login.LoginResponseDto
import com.example.animals.domain.model.LoginLogoutActivity
import java.util.UUID

interface LoginService {
    fun login(request: LoginRequestDto): LoginResponseDto

    fun logLoginLogoutActivity(uuid: UUID?, action: String)
}