package com.yohesu.kelontong.application.services.user

import com.yohesu.kelontong.application.usecases.user.CreateUserUseCase
import com.yohesu.kelontong.domain.exceptions.EmailAlreadyExistsException
import com.yohesu.kelontong.domain.exceptions.UsernameAlreadyExistsException
import com.yohesu.kelontong.domain.model.User
import com.yohesu.kelontong.domain.model.UserRole
import com.yohesu.kelontong.domain.presentation.dtos.user.response.UserDTO
import com.yohesu.kelontong.domain.repository.UserRepository
import com.yohesu.kelontong.presentation.dtos.user.request.CreateUserRequest
import com.yohesu.kelontong.presentation.mappers.UserMapper
import org.springframework.stereotype.Service

@Service
class CreateUserServiceImpl(
    private val userRepository: UserRepository
) : CreateUserUseCase {

    override fun execute(request: CreateUserRequest): UserDTO {

        if (userRepository.existsByUsername(request.username)) {
            throw UsernameAlreadyExistsException(
                "Username '${request.username}' already exists"
            )
        }

        if (userRepository.existsByEmail(request.email)) {
            throw EmailAlreadyExistsException(
                "Email '${request.email}' already exists"
            )
        }

        val role = try {
            UserRole.valueOf(request.role.lowercase())
        } catch (exception: IllegalArgumentException) {
            throw IllegalArgumentException(
                "Invalid role: ${request.role}"
            )
        }

        val user = User(
            name = request.name,
            username = request.username,
            email = request.email,
            password = request.password,
            role = role
        )

        val savedUser = userRepository.save(user)

        return UserMapper.mapToDto(savedUser)
    }

}