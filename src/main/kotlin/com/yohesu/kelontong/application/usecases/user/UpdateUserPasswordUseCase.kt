package com.yohesu.kelontong.application.usecases.user

import com.yohesu.kelontong.presentation.dtos.user.request.UpdatePasswordRequest

interface UpdateUserPasswordUseCase {

    fun execute(id: Long, request: UpdatePasswordRequest)
}