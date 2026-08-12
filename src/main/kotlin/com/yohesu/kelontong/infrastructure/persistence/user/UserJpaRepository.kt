package com.yohesu.kelontong.infrastructure.persistence.user

import com.yohesu.kelontong.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.Optional

interface UserJpaRepository : JpaRepository<User, Long> {

    fun findAllByIsActiveTrue(pageable: Pageable): Page<User>

    fun findByIdAndIsActiveTrue(id: Long): Optional<User>

    fun existsByUsername(username: String): Boolean

    fun existsByEmail(email: String): Boolean

    fun existsByUsernameAndIdNot(username: String, id: Long): Boolean

    fun existsByEmailAndIdNot(email: String, id: Long): Boolean
}