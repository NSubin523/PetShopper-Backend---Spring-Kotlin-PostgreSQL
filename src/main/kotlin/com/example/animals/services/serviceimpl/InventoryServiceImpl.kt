package com.example.animals.services.serviceimpl

import com.example.animals.data.dto.inventory.InventoryListResponseDto
import com.example.animals.data.mapper.inventory.InventoryMapper
import com.example.animals.exception.invalid.CategoryNotFoundException
import com.example.animals.repository.CategoryRepository
import com.example.animals.repository.InventoryRepository
import com.example.animals.services.service.InventoryService
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class InventoryServiceImpl(
    private val inventoryRepository: InventoryRepository,
    private val categoryRepository: CategoryRepository
): InventoryService {
    override fun getInventoryByCategoryUuid(
        categoryUuid: UUID,
        page: Int,
        pageSize: Int
    ): InventoryListResponseDto {

        if(!categoryRepository.existsById(categoryUuid)){
            throw CategoryNotFoundException(
                resourceName = "Category",
                fieldName = "categoryUuid",
                fieldValue = categoryUuid.toString()
            )
        }

        val pageable = PageRequest.of(page, pageSize)
        val pageResult = inventoryRepository.findByCategoryId(categoryUuid, pageable)
        val items = pageResult.content.map(InventoryMapper::toListItemResponse)

        return InventoryListResponseDto(
            items = items,
            page = page,
            pageSize = pageSize,
            totalCount = pageResult.totalElements.toInt(),
            hasMore = pageResult.hasNext()
        )
    }
}