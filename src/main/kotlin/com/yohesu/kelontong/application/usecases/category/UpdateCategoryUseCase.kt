package com.yohesu.kelontong.application.usecases.category

import com.yohesu.kelontong.presentation.dtos.category.request.UpdateCategoryRequest
import com.yohesu.kelontong.presentation.dtos.category.response.CategoryDTO

interface UpdateCategoryUseCase {

    fun execute(
        id: Long,
        request: UpdateCategoryRequest,
        userId: Long?
    ): CategoryDTO
}