package com.yohesu.kelontong.application.usecases.category

import com.yohesu.kelontong.presentation.dtos.category.request.CreateCategoryRequest
import com.yohesu.kelontong.presentation.dtos.category.response.CategoryDTO

interface CreateCategoryUseCase {

    fun execute(
        request: CreateCategoryRequest,
        userId: Long?
    ): CategoryDTO
}