package com.yohesu.kelontong.application.usecases.category

import com.yohesu.kelontong.presentation.dtos.category.response.CategoryDTO

interface GetCategoryUseCase {

    fun execute(
        id: Long
    ): CategoryDTO
}