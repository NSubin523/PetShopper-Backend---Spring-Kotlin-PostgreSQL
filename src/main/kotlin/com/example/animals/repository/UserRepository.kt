package com.example.animals.repository

import com.example.animals.domain.model.UserModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<UserModel, UUID> {
    fun findByEmail(email: String): UserModel?
    fun existsByEmail(email: String): Boolean
}