package com.example.animals.events.auth.listener

import com.example.animals.events.auth.event.AuthenticationEvent
import com.example.animals.services.service.AuthService
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class LogAuthenticationTime(
    private val authService: AuthService
) {

    @EventListener
    fun logAuthenticationTime(event: AuthenticationEvent) {
        authService.logAuthenticationActivity(event.uuid, event.action)
    }
}