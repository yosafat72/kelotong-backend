package com.yohesu.kelontong.application.usecases.user

import com.yohesu.kelontong.domain.presentation.dtos.user.response.UserDTO
import com.yohesu.kelontong.presentation.dtos.user.request.CreateUserRequest

interface CreateUserUseCase {
    fun execute(request: CreateUserRequest): UserDTO
}