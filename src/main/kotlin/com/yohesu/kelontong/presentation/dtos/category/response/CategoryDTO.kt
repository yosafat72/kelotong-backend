package com.yohesu.kelontong.presentation.dtos.category.response

import java.time.LocalDateTime

data class CategoryDTO(

    val id: Long,
    val name: String,
    val description: String?,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
)