package com.yohesu.kelontong.presentation.dtos.supplier.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UpdateSupplierRequest(

    @field:NotBlank(message = "Name is required")
    @field:Size(max = 255, message = "Name must not exceed 255 characters")
    val name: String,

    @field:Size(max = 255, message = "Contact person must not exceed 255 characters")
    val contactPerson: String? = null,

    @field:Size(max = 20, message = "Phone must not exceed 20 characters")
    val phone: String? = null,

    @field:Email(message = "Invalid email format")
    @field:Size(max = 255, message = "Email must not exceed 255 characters")
    val email: String? = null,

    val address: String? = null

)
