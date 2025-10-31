package com.example.animals.data.mapper.activity

import com.example.animals.data.dto.activity.LoginLogoutActivityDto
import com.example.animals.domain.model.LoginLogoutActivity

object LoginLogoutActivityMapper {

    fun toEntity(dto: LoginLogoutActivityDto) : LoginLogoutActivity {
        return LoginLogoutActivity(
            userUuid = dto.userUuid,
            eventType = dto.action
        )
    }
}