package com.yohesu.kelontong.domain.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "users")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false, unique = true, length = 50)
    var username: String,

    @Column(nullable = false, unique = true)
    var email: String,

    @Column(name = "email_verified_at")
    var emailVerifiedAt: LocalDateTime? = null,

    @Column(nullable = false)
    var password: String,

    @Column(name = "remember_token", length = 100)
    var rememberToken: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var role: UserRole,

    @Column(name = "created_at")
    var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null
)

enum class UserRole{
    admin,
    kasir,
    pemilik
}