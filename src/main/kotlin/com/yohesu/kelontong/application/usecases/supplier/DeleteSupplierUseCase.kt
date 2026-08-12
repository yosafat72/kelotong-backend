package com.yohesu.kelontong.application.usecases.supplier

interface DeleteSupplierUseCase {

    fun execute(
        id: Long,
        userId: Long? = null
    )
}