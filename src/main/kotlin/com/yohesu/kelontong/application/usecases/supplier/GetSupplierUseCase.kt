package com.yohesu.kelontong.application.usecases.supplier

import com.yohesu.kelontong.presentation.dtos.supplier.response.SupplierDTO

interface GetSupplierUseCase {

    fun execute(
        id: Long
    ): SupplierDTO
}