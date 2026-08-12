package com.yohesu.kelontong.infrastructure.persistence.category

import com.yohesu.kelontong.domain.model.Category
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryJpaRepository : JpaRepository<Category, Long> {

    fun findAllByDeletedAtIsNull(pageable: Pageable): Page<Category>

    fun findByIdAndDeletedAtIsNull(id: Long): Category?

    fun existsByNameAndDeletedAtIsNull(name: String): Boolean

    fun existsByNameAndIdNotAndDeletedAtIsNull(
        name: String,
        id: Long
    ): Boolean
}