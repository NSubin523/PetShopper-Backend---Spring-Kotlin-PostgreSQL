package com.example.animals.util

object Constants {
    val loginEvent: String = "LOGIN"
    val logoutEvent: String = "LOGOUT"

    fun getUserFavoriteKeyForRedis(userId: String): String = "user:$userId:favorites"
}