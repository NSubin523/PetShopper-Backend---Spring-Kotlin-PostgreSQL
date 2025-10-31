package com.example.animals.services.service

import com.example.animals.domain.model.Category

interface CategoryService {
    fun getAllCategories(): List<Category>
}