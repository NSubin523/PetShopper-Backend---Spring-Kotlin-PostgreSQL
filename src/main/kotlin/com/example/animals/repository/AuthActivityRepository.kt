package com.example.animals.repository

import com.example.animals.domain.model.AuthActivityModel
import org.springframework.data.jpa.repository.JpaRepository

interface AuthActivityRepository : JpaRepository<AuthActivityModel, Long>