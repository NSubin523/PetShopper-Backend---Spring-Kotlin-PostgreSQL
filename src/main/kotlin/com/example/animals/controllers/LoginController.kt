package com.example.animals.controllers

import com.example.animals.data.dto.login.LoginRequestDto
import com.example.animals.data.dto.login.LoginResponseDto
import com.example.animals.data.dto.logout.LogoutRequestDto
import com.example.animals.services.service.AuthService
import com.example.animals.util.Constants
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/auth")
class LoginController(
    private val authService: AuthService
) {

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: LoginRequestDto): ResponseEntity<LoginResponseDto> {
        val response : LoginResponseDto = authService.login(request)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

    @PostMapping("/logout")
    fun logout(@Valid @RequestBody request: LogoutRequestDto): ResponseEntity<Void> {
        authService.logAuthenticationActivity(
            UUID.fromString(request.uuid)
            , Constants.logoutEvent
        )

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }

}