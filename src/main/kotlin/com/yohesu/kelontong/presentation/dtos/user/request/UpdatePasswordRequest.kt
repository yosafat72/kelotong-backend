package com.yohesu.kelontong.presentation.dtos.user.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UpdatePasswordRequest(

    @field:NotBlank(message = "Password is required")
    @field:Size(max = 255, message = "Password must not exceed 255 characters")
    val password: String
)