package com.yohesu.kelontong.application.usecases.supplier

import com.yohesu.kelontong.presentation.dtos.supplier.response.SupplierDTO

interface GetSuppliersUseCase {

    fun execute(
        page: Int
    ): List<SupplierDTO>
}