package com.yohesu.kelontong.infrastructure.persistence.category

import com.yohesu.kelontong.domain.model.Category
import com.yohesu.kelontong.domain.repository.CategoryRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class CategoryRepositoryImpl(
    private val categoryJpaRepository: CategoryJpaRepository
) : CategoryRepository {

    override fun findAll(pageable: Pageable): Page<Category> {
        return categoryJpaRepository
            .findAllByDeletedAtIsNull(pageable)
    }

    override fun findById(id: Long): Category? {
        return categoryJpaRepository
            .findByIdAndDeletedAtIsNull(id)
    }

    override fun save(category: Category): Category {
        return categoryJpaRepository.save(category)
    }

    override fun existsByName(name: String): Boolean {
        return categoryJpaRepository
            .existsByNameAndDeletedAtIsNull(name)
    }

    override fun existsByNameAndIdNot(
        name: String,
        id: Long
    ): Boolean {
        return categoryJpaRepository
            .existsByNameAndIdNotAndDeletedAtIsNull(name, id)
    }
}