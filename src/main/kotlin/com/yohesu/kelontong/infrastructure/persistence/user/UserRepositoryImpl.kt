package com.yohesu.kelontong.infrastructure.persistence.user

import com.yohesu.kelontong.domain.model.User
import com.yohesu.kelontong.domain.repository.UserRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl (
    private val userJpaRepository: UserJpaRepository
) : UserRepository {

    override fun findAll(page: Int, size: Int): List<User> {
        val pageIndex = if (page < 1) 0 else page - 1

        return userJpaRepository
            .findAll(PageRequest.of(pageIndex, size))
            .content

    }

}