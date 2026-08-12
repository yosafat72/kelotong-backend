package com.yohesu.kelontong.application.services.user

import com.yohesu.kelontong.application.usecases.user.UpdateUserPasswordUseCase
import com.yohesu.kelontong.domain.exceptions.UserNotFoundException
import com.yohesu.kelontong.domain.repository.UserRepository
import com.yohesu.kelontong.presentation.dtos.user.request.UpdatePasswordRequest
import org.springframework.stereotype.Service

@Service
class UpdateUserPasswordServiceImpl(
    private val userRepository: UserRepository
) : UpdateUserPasswordUseCase {

    override fun execute(id: Long, request: UpdatePasswordRequest) {

        val user = userRepository.findActiveById(id) ?: throw UserNotFoundException("User with id $id not found")

        user.password = request.password

        userRepository.save(user)
    }
}