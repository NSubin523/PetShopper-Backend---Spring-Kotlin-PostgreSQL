package com.example.animals.data.mapper.login

import com.example.animals.data.dto.login.LoginResponseDto
import com.example.animals.data.mapper.user.UserMapper
import com.example.animals.domain.model.UserModel

object LoginMapper {
    fun toLoginResponseDto(user: UserModel, jwtToken: String): LoginResponseDto {
        return LoginResponseDto(
            user = UserMapper.toLoginResponseDto(user),
            jwtToken = jwtToken,
            refreshToken = ""
        )
    }
}