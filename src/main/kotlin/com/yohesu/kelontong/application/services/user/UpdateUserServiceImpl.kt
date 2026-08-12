package com.yohesu.kelontong.application.services.user

import com.yohesu.kelontong.application.usecases.user.UpdateUserUseCase
import com.yohesu.kelontong.domain.exceptions.EmailAlreadyExistsException
import com.yohesu.kelontong.domain.exceptions.UserNotFoundException
import com.yohesu.kelontong.domain.exceptions.UsernameAlreadyExistsException
import com.yohesu.kelontong.domain.model.UserRole
import com.yohesu.kelontong.domain.presentation.dtos.user.response.UserDTO
import com.yohesu.kelontong.domain.repository.UserRepository
import com.yohesu.kelontong.presentation.dtos.user.request.UpdateUserRequest
import com.yohesu.kelontong.presentation.mappers.UserMapper
import org.springframework.stereotype.Service

@Service
class UpdateUserServiceImpl(
    private val userRepository: UserRepository
) : UpdateUserUseCase {

    override fun execute(
        id: Long,
        request: UpdateUserRequest
    ): UserDTO {

        // 1. Find user
        val user = userRepository.findActiveById(id)
            ?: throw UserNotFoundException(
                "User with id $id not found"
            )

        // 2. Normalize input
        val username = request.username.trim()
        val email = request.email.trim().lowercase()

        // 3. Check username
        if (userRepository.existsByUsernameAndIdNot(username, id)) {
            throw UsernameAlreadyExistsException(
                "Username '$username' already exists"
            )
        }

        // 4. Check email
        if (userRepository.existsByEmailAndIdNot(email, id)) {
            throw EmailAlreadyExistsException(
                "Email '$email' already exists"
            )
        }

        // 5. Validate role
        val role = try { UserRole.valueOf(request.role.trim().lowercase()) }
        catch (exception: IllegalArgumentException) {
            throw IllegalArgumentException(
                "Invalid role: ${request.role}"
            )
        }

        // 6. Update entity
        user.name = request.name.trim()
        user.username = username
        user.email = email
        user.role = role

        // 7. Save
        val updatedUser = userRepository.save(user)

        // 8. Map response
        return UserMapper.mapToDto(updatedUser)
    }
}