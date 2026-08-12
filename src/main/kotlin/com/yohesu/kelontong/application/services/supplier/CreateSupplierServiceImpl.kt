package com.yohesu.kelontong.application.services.supplier

import com.yohesu.kelontong.application.usecases.supplier.CreateSupplierUseCase
import com.yohesu.kelontong.domain.exceptions.DuplicateResourceException
import com.yohesu.kelontong.domain.model.Supplier
import com.yohesu.kelontong.domain.repository.SupplierRepository
import com.yohesu.kelontong.presentation.dtos.supplier.request.CreateSupplierRequest
import com.yohesu.kelontong.presentation.dtos.supplier.response.SupplierDTO
import com.yohesu.kelontong.presentation.mappers.SupplierMapper
import org.springframework.stereotype.Service

@Service
class CreateSupplierServiceImpl(
    private val supplierRepository: SupplierRepository
) : CreateSupplierUseCase {

    override fun execute(
        request: CreateSupplierRequest,
        userId: Long?
    ): SupplierDTO {

        if (
            request.email != null &&
            supplierRepository.existsByEmail(request.email)
        ) {
            throw DuplicateResourceException(
                "Supplier with email '${request.email}' already exists"
            )
        }

        val supplier = Supplier(
            name = request.name,
            contactPerson = request.contactPerson,
            phone = request.phone,
            email = request.email,
            address = request.address,
            createdBy = userId
        )

        val savedSupplier = supplierRepository.save(supplier)

        return SupplierMapper.mapToDto(savedSupplier)
    }
}