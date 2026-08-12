package com.yohesu.kelontong.presentation.mappers

import com.yohesu.kelontong.domain.model.Supplier
import com.yohesu.kelontong.presentation.dtos.supplier.response.SupplierDTO

object SupplierMapper {

    fun mapToDto(
        supplier: Supplier
    ): SupplierDTO {

        return SupplierDTO(
            id = supplier.id
                ?: throw IllegalStateException(
                    "Supplier ID cannot be null"
                ),
            name = supplier.name,
            contactPerson = supplier.contactPerson,
            phone = supplier.phone,
            email = supplier.email,
            address = supplier.address,
            createdAt = supplier.createdAt,
            updatedAt = supplier.updatedAt
        )
    }

}