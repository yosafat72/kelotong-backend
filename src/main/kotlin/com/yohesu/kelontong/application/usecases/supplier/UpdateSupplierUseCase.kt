package com.yohesu.kelontong.application.usecases.supplier

import com.yohesu.kelontong.presentation.dtos.supplier.request.UpdateSupplierRequest
import com.yohesu.kelontong.presentation.dtos.supplier.response.SupplierDTO

interface UpdateSupplierUseCase {

    fun execute(
        id: Long,
        request: UpdateSupplierRequest,
        userId: Long? = null
    ): SupplierDTO
}