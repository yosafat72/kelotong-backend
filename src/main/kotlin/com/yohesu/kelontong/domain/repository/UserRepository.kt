package com.yohesu.kelontong.domain.repository

import com.yohesu.kelontong.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository {

    fun findAll(page: Int, size: Int): List<User>

}