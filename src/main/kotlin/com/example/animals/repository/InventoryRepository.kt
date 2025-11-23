package com.example.animals.repository

import com.example.animals.domain.model.Inventory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface InventoryRepository: JpaRepository<Inventory, UUID> {
    fun findByCategoryId(categoryId: UUID, pageable: Pageable): Page<Inventory>
}