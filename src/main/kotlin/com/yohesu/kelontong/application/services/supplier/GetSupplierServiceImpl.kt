package com.yohesu.kelontong.application.services.supplier

import com.yohesu.kelontong.application.usecases.supplier.GetSupplierUseCase
import com.yohesu.kelontong.domain.exceptions.ResourceNotFoundException
import com.yohesu.kelontong.domain.repository.SupplierRepository
import com.yohesu.kelontong.presentation.dtos.supplier.response.SupplierDTO
import com.yohesu.kelontong.presentation.mappers.SupplierMapper
import org.springframework.stereotype.Service

@Service
class GetSupplierServiceImpl(
    private val supplierRepository: SupplierRepository
) : GetSupplierUseCase {

    override fun execute(
        id: Long
    ): SupplierDTO {

        val supplier = supplierRepository.findById(id)
            ?: throw ResourceNotFoundException(
                "Supplier with id $id not found"
            )

        return SupplierMapper.mapToDto(supplier)
    }
}