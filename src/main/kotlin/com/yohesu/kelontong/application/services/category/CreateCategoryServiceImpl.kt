package com.yohesu.kelontong.application.services.category

import com.yohesu.kelontong.application.usecases.category.CreateCategoryUseCase
import com.yohesu.kelontong.domain.exceptions.DuplicateResourceException
import com.yohesu.kelontong.domain.model.Category
import com.yohesu.kelontong.domain.repository.CategoryRepository
import com.yohesu.kelontong.presentation.dtos.category.request.CreateCategoryRequest
import com.yohesu.kelontong.presentation.dtos.category.response.CategoryDTO
import com.yohesu.kelontong.presentation.mappers.CategoryMapper
import org.springframework.stereotype.Service

@Service
class CreateCategoryServiceImpl(
    private val categoryRepository: CategoryRepository
) : CreateCategoryUseCase {

    override fun execute(
        request: CreateCategoryRequest,
        userId: Long?
    ): CategoryDTO {

        if (categoryRepository.existsByName(request.name)) {
            throw DuplicateResourceException(
                "Category with name '${request.name}' already exists"
            )
        }

        val category = Category(
            name = request.name,
            description = request.description,
            createdBy = userId
        )

        val savedCategory = categoryRepository.save(category)

        return CategoryMapper.mapToDto(savedCategory)
    }
}