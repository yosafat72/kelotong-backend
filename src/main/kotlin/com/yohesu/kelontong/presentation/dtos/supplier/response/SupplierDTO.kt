package com.yohesu.kelontong.presentation.dtos.supplier.response

import java.time.LocalDateTime

data class SupplierDTO(
    val id: Long,
    val name: String,
    val contactPerson: String?,
    val phone: String?,
    val email: String?,
    val address: String?,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
)
