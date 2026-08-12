package com.yohesu.kelontong.infrastructure.persistence.supplier

import com.yohesu.kelontong.domain.model.Supplier
import com.yohesu.kelontong.domain.repository.SupplierRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class SupplierRepositoryImpl(
    private val supplierJpaRepository: SupplierJpaRepository
) : SupplierRepository {

    override fun findAll(
        pageable: Pageable
    ): Page<Supplier> {

        return supplierJpaRepository
            .findAllByDeletedAtIsNull(pageable)
    }

    override fun findById(
        id: Long
    ): Supplier? {

        return supplierJpaRepository
            .findByIdAndDeletedAtIsNull(id)
    }

    override fun existsByEmail(
        email: String
    ): Boolean {

        return supplierJpaRepository
            .existsByEmailAndDeletedAtIsNull(email)
    }

    override fun existsByEmailAndIdNot(
        email: String,
        id: Long
    ): Boolean {

        return supplierJpaRepository
            .existsByEmailAndIdNotAndDeletedAtIsNull(
                email,
                id
            )
    }

    override fun save(
        supplier: Supplier
    ): Supplier {

        return supplierJpaRepository.save(supplier)
    }
}