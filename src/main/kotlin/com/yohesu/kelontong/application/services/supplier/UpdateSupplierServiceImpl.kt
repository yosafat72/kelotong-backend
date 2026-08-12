package com.yohesu.kelontong.application.services.supplier

import com.yohesu.kelontong.application.usecases.supplier.UpdateSupplierUseCase
import com.yohesu.kelontong.domain.exceptions.DuplicateResourceException
import com.yohesu.kelontong.domain.exceptions.ResourceNotFoundException
import com.yohesu.kelontong.domain.repository.SupplierRepository
import com.yohesu.kelontong.presentation.dtos.supplier.request.UpdateSupplierRequest
import com.yohesu.kelontong.presentation.dtos.supplier.response.SupplierDTO
import com.yohesu.kelontong.presentation.mappers.SupplierMapper
import org.springframework.stereotype.Service

@Service
class UpdateSupplierServiceImpl(
    private val supplierRepository: SupplierRepository
) : UpdateSupplierUseCase {

    override fun execute(
        id: Long,
        request: UpdateSupplierRequest,
        userId: Long?
    ): SupplierDTO {

        val supplier = supplierRepository.findById(id)
            ?: throw ResourceNotFoundException(
                "Supplier with id $id not found"
            )

        if (
            request.email != null &&
            supplierRepository.existsByEmailAndIdNot(
                request.email,
                id
            )
        ) {
            throw DuplicateResourceException(
                "Supplier with email '${request.email}' already exists"
            )
        }

        supplier.name = request.name
        supplier.contactPerson = request.contactPerson
        supplier.phone = request.phone
        supplier.email = request.email
        supplier.address = request.address
        supplier.updatedBy = userId

        val updatedSupplier = supplierRepository.save(supplier)

        return SupplierMapper.mapToDto(updatedSupplier)
    }
}