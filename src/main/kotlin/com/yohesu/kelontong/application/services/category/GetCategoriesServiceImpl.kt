package com.yohesu.kelontong.application.services.category

import com.yohesu.kelontong.application.usecases.category.GetCategoriesUseCase
import com.yohesu.kelontong.domain.repository.CategoryRepository
import com.yohesu.kelontong.presentation.dtos.category.response.CategoryDTO
import com.yohesu.kelontong.presentation.mappers.CategoryMapper
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class GetCategoriesServiceImpl(
    private val categoryRepository: CategoryRepository
) : GetCategoriesUseCase {

    override fun execute(
        page: Int
    ): List<CategoryDTO> {

        val pageIndex = if (page < 1) {
            0
        } else {
            page - 1
        }

        val categories = categoryRepository
            .findAll(
                PageRequest.of(
                    pageIndex,
                    10
                )
            )
            .content

        return categories.map {
            CategoryMapper.mapToDto(it)
        }
    }
}