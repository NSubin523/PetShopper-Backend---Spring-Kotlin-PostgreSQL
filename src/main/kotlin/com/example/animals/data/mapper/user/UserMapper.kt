package com.example.animals.data.mapper.user

import com.example.animals.data.dto.user.CreateUserRequestDto
import com.example.animals.data.dto.user.UserLoginResponseDto
import com.example.animals.domain.model.UserModel
import java.time.LocalDateTime

object UserMapper {
    fun toEntity(request: CreateUserRequestDto): UserModel {
        return UserModel(
            firstName = request.firstName,
            lastName = request.lastName,
            email = request.email,
            password = request.password,
            phoneNumber = request.phoneNumber,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
    }

    fun toLoginResponseDto(model: UserModel): UserLoginResponseDto {
        return UserLoginResponseDto(
            uuid = model.uuid.toString(),
            firstName = model.firstName,
            lastName = model.lastName,
            email = model.email,
            phoneNumber = model.phoneNumber,
            createdAt = model.createdAt
        )
    }
}