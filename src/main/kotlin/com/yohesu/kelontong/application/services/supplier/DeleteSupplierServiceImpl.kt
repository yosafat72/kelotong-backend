package com.yohesu.kelontong.application.services.supplier

import com.yohesu.kelontong.application.usecases.supplier.DeleteSupplierUseCase
import com.yohesu.kelontong.domain.exceptions.ResourceNotFoundException
import com.yohesu.kelontong.domain.repository.SupplierRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class DeleteSupplierServiceImpl(
    private val supplierRepository: SupplierRepository
) : DeleteSupplierUseCase {

    override fun execute(
        id: Long,
        userId: Long?
    ) {

        val supplier = supplierRepository.findById(id)
            ?: throw ResourceNotFoundException(
                "Supplier with id $id not found"
            )

        supplier.deletedAt = LocalDateTime.now()
        supplier.updatedBy = userId

        supplierRepository.save(supplier)
    }
}