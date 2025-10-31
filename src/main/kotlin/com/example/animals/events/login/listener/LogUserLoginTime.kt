package com.example.animals.events.login.listener

import com.example.animals.events.login.event.UserLoginEvent
import com.example.animals.services.service.LoginService
import com.example.animals.util.Constants
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class LogUserLoginTime(
    private val loginService: LoginService,
) {

    @EventListener
    fun logUserLoginTime(event: UserLoginEvent) {
        loginService.logLoginLogoutActivity(event.uuid, Constants.loginEvent)
    }
}