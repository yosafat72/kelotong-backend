package com.yohesu.kelontong.presentation.dtos.category.request

data class UpdateCategoryRequest(
    val name: String,
    val description: String? = null
)