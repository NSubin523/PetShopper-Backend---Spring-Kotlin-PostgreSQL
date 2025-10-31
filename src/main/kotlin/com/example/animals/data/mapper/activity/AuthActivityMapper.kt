package com.example.animals.data.mapper.activity

import com.example.animals.data.dto.activity.AuthActivityDto
import com.example.animals.domain.model.AuthActivityModel

object AuthActivityMapper {

    fun toEntity(dto: AuthActivityDto) : AuthActivityModel {
        return AuthActivityModel(
            userUuid = dto.userUuid,
            eventType = dto.action
        )
    }
}