package com.yohesu.kelontong.presentation.dtos.category.request

data class CreateCategoryRequest(
    val name: String,
    val description: String? = null
)