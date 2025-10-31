package com.example.animals.services.service

import com.example.animals.domain.model.UserModel

interface UserService {
    fun createUser(user: UserModel): UserModel
    fun getUserByEmail(email: String): UserModel?
}