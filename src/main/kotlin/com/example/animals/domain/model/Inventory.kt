package com.example.animals.domain.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "inventory")
data class Inventory(
    @Id @GeneratedValue
    val uuid: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val categoryId: UUID,

    val name: String,
    val description: String?,
    val imageUrl: String,
    val locatedAt: String?,

    @Column(nullable = false)
    val zipCode: String,
    val priceMin: BigDecimal,
    val priceMax: BigDecimal,
    val age: Int?,
    val gender: String?,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val availability: Availability,

    val availableDate: LocalDateTime,
    val isAdopted: Boolean,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)
