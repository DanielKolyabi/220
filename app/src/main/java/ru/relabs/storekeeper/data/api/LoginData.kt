package ru.relabs.storekeeper.data.api

data class LoginData(
    val username: String,
    val password: String
)

data class UserData(
    val userId: String,
    val sessionToken: String
)