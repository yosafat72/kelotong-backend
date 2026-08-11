package com.yohesu.kelontong.domain.presentation.dtos.user.response

import java.time.LocalDateTime

data class UserDTO(
    val id: Long? = 0,
    val name: String? = "",
    val username: String? = "",
    val email: String? = "",
    val role: String? = "",
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null
)