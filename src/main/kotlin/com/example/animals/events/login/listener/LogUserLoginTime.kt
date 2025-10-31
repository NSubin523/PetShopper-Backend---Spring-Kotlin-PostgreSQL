package com.example.animals.events.login.listener

import com.example.animals.data.dto.activity.LoginLogoutActivityDto
import com.example.animals.data.mapper.activity.LoginLogoutActivityMapper
import com.example.animals.events.login.event.UserLoginEvent
import com.example.animals.repository.LoginLogoutRepository
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class LogUserLoginTime(
    private val loginLogoutRepository: LoginLogoutRepository,
) {

    @EventListener
    fun logUserLoginTime(event: UserLoginEvent) {
        val activityDto = LoginLogoutActivityDto(
            userUuid = event.uuid,
            action = event.action
        )

        val entity = LoginLogoutActivityMapper.toEntity(activityDto)

        loginLogoutRepository.save(entity)

    }
}