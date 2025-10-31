package com.example.animals.services.serviceimpl

import com.example.animals.domain.model.UserModel
import com.example.animals.events.usercreation.event.UserCreatedEvent
import com.example.animals.exception.duplicate.DuplicateResourceException
import com.example.animals.repository.UserRepository
import com.example.animals.services.service.UserService
import org.springframework.context.ApplicationEventPublisher
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepo: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val eventPublisher: ApplicationEventPublisher
) : UserService {
    override fun createUser(user: UserModel): UserModel {
        if (userRepo.existsByEmail(user.email)){
            throw DuplicateResourceException(
                "User",
                "email",
                user.email
            )
        }

        val entity = user.copy(password = passwordEncoder.encode(user.password))

        val createdUser = userRepo.save(entity)

        //Listener listens to new user being created and sends welcome email
        eventPublisher.publishEvent(UserCreatedEvent(this, createdUser))

        return createdUser
    }

    override fun getUserByEmail(email: String): UserModel? {
        return userRepo.findByEmail(email)
    }
}