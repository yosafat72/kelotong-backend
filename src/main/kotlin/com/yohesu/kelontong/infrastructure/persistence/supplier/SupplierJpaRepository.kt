package com.yohesu.kelontong.infrastructure.persistence.supplier

import com.yohesu.kelontong.domain.model.Supplier
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository


interface SupplierJpaRepository : JpaRepository<Supplier, Long> {

    fun findAllByDeletedAtIsNull(
        pageable: Pageable
    ): Page<Supplier>

    fun findByIdAndDeletedAtIsNull(
        id: Long
    ): Supplier?

    fun existsByEmailAndDeletedAtIsNull(
        email: String
    ): Boolean

    fun existsByEmailAndIdNotAndDeletedAtIsNull(
        email: String,
        id: Long
    ): Boolean
}