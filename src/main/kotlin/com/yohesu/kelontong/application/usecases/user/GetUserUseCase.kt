package com.yohesu.kelontong.application.usecases.user

import com.yohesu.kelontong.domain.presentation.dtos.user.response.UserDTO

interface GetUserUseCase {

    fun execute(id: Long): UserDTO
}