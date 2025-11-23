package com.example.animals.data.mapper.inventory

import com.example.animals.data.dto.inventory.InventoryItemResponse
import com.example.animals.domain.model.Inventory

object InventoryMapper {
    fun toListItemResponse(entity: Inventory): InventoryItemResponse {
        return InventoryItemResponse(
            uuid = entity.uuid,
            name = entity.name,
            imageUrl = entity.imageUrl,
            zipCode = entity.zipCode,
            priceMin = entity.priceMin,
            priceMax = entity.priceMax,
            age = entity.age,
            gender = entity.gender,
            availability = entity.availability
        )
    }
}