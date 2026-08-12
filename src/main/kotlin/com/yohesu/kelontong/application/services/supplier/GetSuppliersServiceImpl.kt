package com.yohesu.kelontong.application.services.supplier

import com.yohesu.kelontong.application.usecases.supplier.GetSuppliersUseCase
import com.yohesu.kelontong.domain.repository.SupplierRepository
import com.yohesu.kelontong.presentation.dtos.supplier.response.SupplierDTO
import com.yohesu.kelontong.presentation.mappers.SupplierMapper
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class GetSuppliersServiceImpl(
    private val supplierRepository: SupplierRepository
) : GetSuppliersUseCase {

    override fun execute(
        page: Int
    ): List<SupplierDTO> {

        val pageIndex = if (page < 1) {
            0
        } else {
            page - 1
        }

        val suppliers = supplierRepository
            .findAll(
                PageRequest.of(
                    pageIndex,
                    10
                )
            )
            .content

        return suppliers.map {
            SupplierMapper.mapToDto(it)
        }
    }
}