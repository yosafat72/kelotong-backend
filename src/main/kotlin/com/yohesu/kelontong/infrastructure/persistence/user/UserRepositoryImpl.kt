package com.yohesu.kelontong.infrastructure.persistence.user

import com.yohesu.kelontong.domain.model.User
import com.yohesu.kelontong.domain.repository.UserRepository
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl (
    private val userJpaRepository: UserJpaRepository
) : UserRepository {

    override fun findById(userId: Long): User? {
        return userJpaRepository.findById(userId).orElse(null)
    }

    override fun existsByUsername(username: String): Boolean {
        return userJpaRepository.existsByUsername(username)
    }

    override fun existsByEmail(email: String): Boolean {
        return userJpaRepository.existsByEmail(email)
    }

    override fun existsByUsernameAndIdNot(username: String, id: Long): Boolean {
        return userJpaRepository.existsByUsernameAndIdNot(username, id)
    }

    override fun existsByEmailAndIdNot(email: String, id: Long): Boolean {
        return userJpaRepository.existsByEmailAndIdNot(email, id)
    }

    override fun findAll(page: Int, size: Int): List<User> {
        val pageIndex = if (page < 1) 0 else page - 1

        return userJpaRepository
            .findAll(PageRequest.of(pageIndex, size))
            .content

    }

    override fun save(user: User): User {
        return userJpaRepository.save(user)
    }

}