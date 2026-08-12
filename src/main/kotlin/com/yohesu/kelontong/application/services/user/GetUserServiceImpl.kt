package com.yohesu.kelontong.application.services.user

import com.yohesu.kelontong.application.usecases.user.GetUserUseCase
import com.yohesu.kelontong.domain.exceptions.UserNotFoundException
import com.yohesu.kelontong.domain.presentation.dtos.user.response.UserDTO
import com.yohesu.kelontong.domain.repository.UserRepository
import com.yohesu.kelontong.presentation.mappers.UserMapper
import org.springframework.stereotype.Service

@Service
class GetUserServiceImpl(
    private val userRepository: UserRepository
) : GetUserUseCase {

    override fun execute(id: Long): UserDTO {

        val user = userRepository.findActiveById(id)
            ?: throw UserNotFoundException(
                "User with id $id not found"
            )

        return UserMapper.mapToDto(user)
    }
}