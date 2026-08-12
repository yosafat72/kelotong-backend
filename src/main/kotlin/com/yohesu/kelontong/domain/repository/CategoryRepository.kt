package com.yohesu.kelontong.domain.repository

import com.yohesu.kelontong.domain.model.Category
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CategoryRepository {

    fun findAll(pageable: Pageable): Page<Category>

    fun findById(id: Long): Category?

    fun save(category: Category): Category

    fun existsByName(name: String): Boolean

    fun existsByNameAndIdNot(
        name: String,
        id: Long
    ): Boolean
}