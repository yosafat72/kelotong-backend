package com.yohesu.kelontong.application.usecases.user

import com.yohesu.kelontong.domain.presentation.dtos.user.response.UserDTO
import com.yohesu.kelontong.presentation.dtos.user.request.UpdateUserRequest

interface UpdateUserUseCase {

    fun execute(
        id: Long,
        request: UpdateUserRequest
    ): UserDTO

}