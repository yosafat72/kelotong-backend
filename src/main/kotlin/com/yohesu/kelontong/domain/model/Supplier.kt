package com.yohesu.kelontong.domain.model

import jakarta.persistence.*
import jakarta.persistence.GenerationType
import java.time.LocalDateTime

@Entity
@Table(name = "suppliers")
class Supplier(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @Column(name = "contact_person")
    var contactPerson: String? = null,

    @Column(length = 20)
    var phone: String? = null,

    @Column(unique = true)
    var email: String? = null,

    @Column(columnDefinition = "TEXT")
    var address: String? = null,

    @Column(name = "created_at", updatable = false)
    var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null,

    @Column(name = "created_by")
    var createdBy: Long? = null,

    @Column(name = "updated_by")
    var updatedBy: Long? = null,

    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime? = null
)