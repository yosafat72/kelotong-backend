package com.yohesu.kelontong.domain.repository

import com.yohesu.kelontong.domain.model.Supplier
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface SupplierRepository {

    fun findAll(pageable: Pageable): Page<Supplier>

    fun findById(id: Long): Supplier?

    fun existsByEmail(email: String): Boolean

    fun existsByEmailAndIdNot(
        email: String,
        id: Long
    ): Boolean

    fun save(supplier: Supplier): Supplier

}