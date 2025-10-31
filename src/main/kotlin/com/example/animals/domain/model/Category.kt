package com.example.animals.domain.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "animals")
data class Category(

    @Id @GeneratedValue
    val id: UUID,

    @Column(name = "type")
    val type: String,

    @Column(name = "description")
    val description: String?,

    @Column(name = "image_url")
    val imageUrl: String,

    @Column(name = "created_at")
    val createdAt: Date,

    @Column(name = "updated_at")
    val updatedAt: Date
)