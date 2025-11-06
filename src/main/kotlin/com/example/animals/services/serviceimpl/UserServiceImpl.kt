package com.example.animals.services.serviceimpl

import com.example.animals.domain.model.UserModel
import com.example.animals.events.usercreation.event.UserCreatedEvent
import com.example.animals.exception.duplicate.DuplicateResourceException
import com.example.animals.repository.UserRepository
import com.example.animals.services.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepo: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val eventPublisher: ApplicationEventPublisher
) : UserService {
    override fun createUser(user: UserModel): Int {

        val logger = LoggerFactory.getLogger(UserServiceImpl::class.java)

        if (userRepo.existsByEmail(user.email)){
            throw DuplicateResourceException(
                "User",
                "email",
                user.email
            )
        }

        return runCatching {
            val encodedUser = user.copy(password = passwordEncoder.encode(user.password))
            val created = userRepo.save(encodedUser)
            eventPublisher.publishEvent(UserCreatedEvent(this, created))
            HttpStatus.CREATED.value()
        }.getOrElse { ex ->
            logger.error("Error while creating new user - " + ex.message, ex)
            HttpStatus.INTERNAL_SERVER_ERROR.value()
        }
    }

    override fun getUserByEmail(email: String): UserModel? {
        return userRepo.findByEmail(email)
    }
}