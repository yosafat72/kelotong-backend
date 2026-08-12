package com.yohesu.kelontong.presentation.dtos.user.request

data class CreateUserRequest (
    val name: String,
    val username: String,
    val email: String,
    val password: String,
    val role: String
)