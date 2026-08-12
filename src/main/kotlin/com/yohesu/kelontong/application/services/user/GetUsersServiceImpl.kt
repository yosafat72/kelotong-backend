package com.yohesu.kelontong.application.services.user

import com.yohesu.kelontong.application.usecases.user.GetUsersUseCase
import com.yohesu.kelontong.domain.repository.UserRepository
import org.springframework.stereotype.Service
import com.yohesu.kelontong.presentation.mappers.UserMapper
import com.yohesu.kelontong.domain.presentation.dtos.user.response.UserDTO

@Service
class GetUsersServiceImpl(private val userRepository: UserRepository) : GetUsersUseCase {

    override fun execute(page: Int): List<UserDTO> {
        val users = userRepository.findAll(page, size = 10)
        return users.map { UserMapper.mapToDto(it) }
    }

}