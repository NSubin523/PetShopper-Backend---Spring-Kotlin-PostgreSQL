package com.example.animals.data.dto.inventory

import com.example.animals.domain.model.Availability
import java.math.BigDecimal
import java.util.UUID

data class InventoryItemResponse(
    val uuid: UUID,
    val name: String,
    val imageUrl: String,
    val zipCode: String,
    val priceMin: BigDecimal,
    val priceMax: BigDecimal,
    val age: Int?,
    val gender: String?,
    val availability: Availability
)

data class InventoryListResponseDto(
    val items: List<InventoryItemResponse>,
    val page: Int,
    val pageSize: Int,
    val totalCount: Int,
    val hasMore: Boolean
)