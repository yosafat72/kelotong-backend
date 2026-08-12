package com.yohesu.kelontong.application.usecases.supplier

import com.yohesu.kelontong.presentation.dtos.supplier.request.CreateSupplierRequest
import com.yohesu.kelontong.presentation.dtos.supplier.response.SupplierDTO

interface CreateSupplierUseCase {

    fun execute(
        request: CreateSupplierRequest,
        userId: Long? = null
    ): SupplierDTO
}