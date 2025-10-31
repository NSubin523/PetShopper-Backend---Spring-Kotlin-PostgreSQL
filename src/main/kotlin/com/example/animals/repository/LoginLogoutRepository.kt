package com.example.animals.repository

import com.example.animals.domain.model.LoginLogoutActivity
import org.springframework.data.jpa.repository.JpaRepository

interface LoginLogoutRepository : JpaRepository<LoginLogoutActivity, Long>