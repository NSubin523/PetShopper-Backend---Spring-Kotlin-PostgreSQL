package com.example.animals.controllers

import com.example.animals.data.dto.inventory.InventoryListResponseDto
import com.example.animals.services.service.InventoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/inventory")
class InventoryController(
    private val inventoryService: InventoryService,
) {

    @GetMapping("/{categoryId}")
    fun getInventoryByCategory(
        @PathVariable("categoryId") categoryId: UUID,
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") pageSize: Int
    ): ResponseEntity<InventoryListResponseDto> {

        val items = inventoryService.getInventoryByCategoryUuid(
            categoryUuid = categoryId,
            page = page,
            pageSize = pageSize
        )

        return ResponseEntity.ok(items)
    }
}