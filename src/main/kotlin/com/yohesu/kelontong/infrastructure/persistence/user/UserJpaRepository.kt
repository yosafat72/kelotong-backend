package com.yohesu.kelontong.infrastructure.persistence.user

import com.yohesu.kelontong.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository : JpaRepository<User, Long> {

}