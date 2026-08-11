package com.yohesu.kelontong.presentation.mappers

import com.yohesu.kelontong.domain.model.User
import com.yohesu.kelontong.domain.presentation.dtos.user.response.UserDTO
import org.springframework.stereotype.Component

@Component
object UserMapper {

    fun mapToDto(user: User): UserDTO {
        return UserDTO(
            id = user.id,
            name = user.name,
            username = user.username,
            email = user.email,
            role = user.role.name,
            createdAt = user.createdAt,
            updatedAt = user.updatedAt
        )
    }

}