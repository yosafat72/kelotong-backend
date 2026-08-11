package com.yohesu.kelontong.application.services.user

import com.yohesu.kelontong.application.usecases.user.GetUsersUseCase
import com.yohesu.kelontong.domain.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.data.domain.PageRequest
import java.util.stream.Collectors
import com.yohesu.kelontong.presentation.mappers.UserMapper
import com.yohesu.kelontong.domain.presentation.dtos.user.response.UserDTO

@Service
class GetUserServiceImpl(private val userRepository: UserRepository) : GetUsersUseCase {

    override fun execute(page: Int): List<UserDTO> {
        val users = userRepository.findAll(PageRequest.of(page, 10)).get().collect(Collectors.toList())
        System.out.println(users)
        return users.map { UserMapper.mapToDto(it) }
    }

}