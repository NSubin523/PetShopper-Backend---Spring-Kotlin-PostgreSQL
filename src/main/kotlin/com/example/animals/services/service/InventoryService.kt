package com.example.animals.services.service

import com.example.animals.data.dto.inventory.InventoryListResponseDto
import java.util.UUID

interface InventoryService {
    fun getInventoryByCategoryUuid(
        categoryUuid: UUID,
        page: Int,
        pageSize: Int,
    ): InventoryListResponseDto
}