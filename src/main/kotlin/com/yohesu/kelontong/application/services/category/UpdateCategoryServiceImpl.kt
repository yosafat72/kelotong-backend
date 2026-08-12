package com.yohesu.kelontong.application.services.category

import com.yohesu.kelontong.application.usecases.category.UpdateCategoryUseCase
import com.yohesu.kelontong.domain.exceptions.DuplicateResourceException
import com.yohesu.kelontong.domain.exceptions.ResourceNotFoundException
import com.yohesu.kelontong.domain.repository.CategoryRepository
import com.yohesu.kelontong.presentation.dtos.category.request.UpdateCategoryRequest
import com.yohesu.kelontong.presentation.dtos.category.response.CategoryDTO
import com.yohesu.kelontong.presentation.mappers.CategoryMapper
import org.springframework.stereotype.Service

@Service
class UpdateCategoryServiceImpl(
    private val categoryRepository: CategoryRepository
) : UpdateCategoryUseCase {

    override fun execute(
        id: Long,
        request: UpdateCategoryRequest,
        userId: Long?
    ): CategoryDTO {

        val category = categoryRepository
            .findById(id)
            ?: throw ResourceNotFoundException(
                "Category with id $id not found"
            )

        if (
            categoryRepository.existsByNameAndIdNot(
                request.name,
                id
            )
        ) {
            throw DuplicateResourceException(
                "Category with name '${request.name}' already exists"
            )
        }

        category.name = request.name
        category.description = request.description
        category.updatedBy = userId

        val updatedCategory =
            categoryRepository.save(category)

        return CategoryMapper.mapToDto(updatedCategory)
    }
}