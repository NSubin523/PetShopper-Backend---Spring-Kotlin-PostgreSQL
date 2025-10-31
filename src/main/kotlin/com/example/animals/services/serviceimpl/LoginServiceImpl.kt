package com.example.animals.services.serviceimpl

import com.example.animals.data.dto.activity.LoginLogoutActivityDto
import com.example.animals.data.dto.login.LoginRequestDto
import com.example.animals.data.dto.login.LoginResponseDto
import com.example.animals.data.mapper.activity.LoginLogoutActivityMapper
import com.example.animals.data.mapper.login.LoginMapper
import com.example.animals.domain.model.UserModel
import com.example.animals.events.login.event.UserLoginEvent
import com.example.animals.exception.credentials.InvalidCredentialsException
import com.example.animals.repository.LoginLogoutRepository
import com.example.animals.repository.UserRepository
import com.example.animals.services.service.LoginService
import com.example.animals.util.Constants
import com.example.animals.util.JwtUtil
import org.springframework.context.ApplicationEventPublisher
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class LoginServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtil: JwtUtil,
    private val eventPublisher: ApplicationEventPublisher,
    private val activityRepo: LoginLogoutRepository
): LoginService{
    override fun login(request: LoginRequestDto): LoginResponseDto {
        try {
            val user : UserModel = userRepository.findByEmail(request.email)
                ?: throw InvalidCredentialsException("Email")

            val doesPasswordMatch = passwordEncoder.matches(request.password, user.password)
            if (!doesPasswordMatch) {
                throw InvalidCredentialsException("Password")
            }

            eventPublisher.publishEvent(UserLoginEvent(this, user.uuid, Constants.loginEvent))
            return LoginMapper.toLoginResponseDto(user, jwtUtil.generateToken(user.email))
        } catch (ex: Exception) {
            throw RuntimeException("Something went wrong", ex)
        }
    }

    override fun logLoginLogoutActivity(uuid: java.util.UUID?, action: String) {
        try {
            val entity = LoginLogoutActivityMapper.toEntity(LoginLogoutActivityDto(
                userUuid = uuid,
                action = action
            ))

            activityRepo.save(entity)
        } catch (ex: Exception) {
            throw RuntimeException("Something went wrong - ", ex)
        }
    }
}