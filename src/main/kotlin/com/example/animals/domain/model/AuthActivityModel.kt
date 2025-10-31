package com.example.animals.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "user_activity_log")
data class AuthActivityModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "user_uuid", nullable = false)
    val userUuid: UUID?,

    @Column(name = "event_type", nullable = false)
    val eventType: String,

    @Column(name = "event_time", nullable = false)
    val eventTime: LocalDateTime = LocalDateTime.now(),
)
