package com.yohesu.kelontong.application.usecases.category

import com.yohesu.kelontong.presentation.dtos.category.response.CategoryDTO

interface GetCategoriesUseCase {

    fun execute(
        page: Int
    ): List<CategoryDTO>
}