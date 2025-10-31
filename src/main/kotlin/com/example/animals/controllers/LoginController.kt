package com.example.animals.controllers

import com.example.animals.data.dto.login.LoginRequestDto
import com.example.animals.data.dto.login.LoginResponseDto
import com.example.animals.services.serviceimpl.LoginServiceImpl
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class LoginController(
    private val loginService: LoginServiceImpl
) {

    @PostMapping("/login")
    fun login(@Valid @RequestBody request: LoginRequestDto): ResponseEntity<LoginResponseDto> {
        val response : LoginResponseDto = loginService.login(request)
        return ResponseEntity.status(HttpStatus.OK).body(response)
    }

}