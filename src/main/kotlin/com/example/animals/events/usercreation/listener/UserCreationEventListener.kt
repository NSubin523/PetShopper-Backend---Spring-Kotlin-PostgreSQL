package com.example.animals.events.usercreation.listener

import com.example.animals.events.usercreation.event.UserCreatedEvent
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class UserCreationEventListener {

    private val logger = LoggerFactory.getLogger(UserCreationEventListener::class.java)

    @EventListener
    fun sendWelcomeEmailToNewlyCreatedUser(event: UserCreatedEvent) {
        val user = event.user

        logger.info("Welcome-created user: ${user.firstName} ${user.lastName}")
        logger.info("Thank you for joining pet shopper. Enjoy shopping")

    }
}