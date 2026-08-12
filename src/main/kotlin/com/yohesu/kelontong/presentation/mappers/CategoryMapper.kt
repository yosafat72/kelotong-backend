package com.yohesu.kelontong.presentation.mappers

import com.yohesu.kelontong.domain.model.Category
import com.yohesu.kelontong.presentation.dtos.category.response.CategoryDTO

object CategoryMapper {

    fun mapToDto(
        category: Category
    ): CategoryDTO {

        return CategoryDTO(
            id = category.id!!,
            name = category.name,
            description = category.description,
            createdAt = category.createdAt,
            updatedAt = category.updatedAt
        )
    }

}