package com.example.animals.controllers

import com.example.animals.data.dto.user.CreateUserRequestDto
import com.example.animals.data.mapper.user.UserMapper
import com.example.animals.services.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
@Validated
class UserController (
    private val userService: UserService
){

    @PostMapping
    fun createNewUser(@Valid @RequestBody request: CreateUserRequestDto): ResponseEntity<Any> {
        val status = userService.createUser(UserMapper.toEntity(request))
        return ResponseEntity.status(
            if (status == HttpStatus.CREATED.value()) HttpStatus.CREATED
            else HttpStatus.INTERNAL_SERVER_ERROR
        ).build()
    }

}