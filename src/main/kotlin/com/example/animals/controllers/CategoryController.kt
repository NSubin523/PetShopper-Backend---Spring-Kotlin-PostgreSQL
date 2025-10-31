package com.example.animals.controllers

import com.example.animals.domain.model.Category
import com.example.animals.services.service.CategoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/categories")
class CategoryController (
    private val categoryService: CategoryService
){
    @GetMapping
    fun getAllCategories(): List<Category> = categoryService.getAllCategories()
}