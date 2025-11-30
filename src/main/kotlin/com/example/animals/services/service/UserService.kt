package com.example.animals.services.service

import com.example.animals.data.dto.inventory.InventoryListResponseDto
import com.example.animals.domain.model.UserModel
import java.util.UUID

interface UserService {
    fun createUser(user: UserModel): Int
    fun getUserByEmail(email: String): UserModel?
    fun getUserFavorites(userId: String, page: Int, pageSize: Int): InventoryListResponseDto
    fun toggleFavorite(userId: String, inventoryId: UUID)
}