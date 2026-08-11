package com.yohesu.kelontong.shared.utils

data class GenericResponse<T>(
    val status: Boolean,
    val message: String,
    val data: T? = null
)