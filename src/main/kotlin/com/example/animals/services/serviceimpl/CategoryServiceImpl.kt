package com.example.animals.services.serviceimpl

import com.example.animals.domain.model.Category
import com.example.animals.repository.CategoryRepository
import com.example.animals.services.service.CategoryService
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository
) : CategoryService {

    override fun getAllCategories(): List<Category> = categoryRepository.findAll()

}