package com.yohesu.kelontong.application.services.category

import com.yohesu.kelontong.application.usecases.category.GetCategoryUseCase
import com.yohesu.kelontong.domain.exceptions.ResourceNotFoundException
import com.yohesu.kelontong.domain.repository.CategoryRepository
import com.yohesu.kelontong.presentation.dtos.category.response.CategoryDTO
import com.yohesu.kelontong.presentation.mappers.CategoryMapper
import org.springframework.stereotype.Service

@Service
class GetCategoryServiceImpl(
    private val categoryRepository: CategoryRepository
) : GetCategoryUseCase {

    override fun execute(
        id: Long
    ): CategoryDTO {

        val category = categoryRepository
            .findById(id)
            ?: throw ResourceNotFoundException(
                "Category with id $id not found"
            )

        return CategoryMapper.mapToDto(category)
    }
}