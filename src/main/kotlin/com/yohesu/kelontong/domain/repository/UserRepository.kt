package com.yohesu.kelontong.domain.repository

import com.yohesu.kelontong.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository {

    fun findActiveById(userId: Long): User?
    fun existsByUsername(username: String): Boolean
    fun existsByEmail(email: String): Boolean
    fun existsByUsernameAndIdNot(username: String, id: Long): Boolean
    fun existsByEmailAndIdNot(email: String, id: Long): Boolean
    fun findAll(page: Int, size: Int): List<User>
    fun save(user: User): User

}