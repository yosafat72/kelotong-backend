package com.yohesu.kelontong.presentation.exceptions

import java.time.LocalDateTime

data class ErrorResponse(
    val status: Boolean = false,
    val message: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)

