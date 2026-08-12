package com.yohesu.kelontong.presentation.dtos.user.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class CreateUserRequest(

    @field:NotBlank(message = "Name is required")
    val name: String,

    @field:NotBlank(message = "Username is required")
    val username: String,

    @field:NotBlank(message = "Email is required")
    @field:Email(message = "Invalid email format")
    val email: String,

    @field:NotBlank(message = "Password is required")
    val password: String,

    @field:NotBlank(message = "Role is required")
    val role: String
)