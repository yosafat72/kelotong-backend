package com.yohesu.kelontong.application.services.user

import com.yohesu.kelontong.application.usecases.user.DeleteUserUseCase
import com.yohesu.kelontong.domain.exceptions.UserNotFoundException
import com.yohesu.kelontong.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class DeleteUserServiceImpl(
    private val userRepository: UserRepository
) : DeleteUserUseCase {

    override fun execute(id: Long) {

        val user = userRepository.findActiveById(id)
            ?: throw UserNotFoundException(
                "User with id $id not found"
            )

        user.isActive = false

        userRepository.save(user)
    }
}