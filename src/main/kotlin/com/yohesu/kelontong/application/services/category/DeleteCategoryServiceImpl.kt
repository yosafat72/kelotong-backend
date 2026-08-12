package com.yohesu.kelontong.application.services.category

import com.yohesu.kelontong.application.usecases.category.DeleteCategoryUseCase
import com.yohesu.kelontong.domain.exceptions.ResourceNotFoundException
import com.yohesu.kelontong.domain.repository.CategoryRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class DeleteCategoryServiceImpl(
    private val categoryRepository: CategoryRepository
) : DeleteCategoryUseCase {

    override fun execute(
        id: Long
    ) {

        val category = categoryRepository
            .findById(id)
            ?: throw ResourceNotFoundException(
                "Category with id $id not found"
            )

        category.deletedAt = LocalDateTime.now()

        categoryRepository.save(category)
    }
}