package com.yohesu.kelontong.domain.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "categories")
class Category (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @Column(columnDefinition = "TEXT")
    var description: String? = null,

    @Column(name = "created_at")
    var createdAt: LocalDateTime? = null,

    @Column(name = "updated_at")
    var updatedAt: LocalDateTime? = null,

    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime? = null,

    @Column(name = "created_by")
    var createdBy: Long? = null,

    @Column(name = "updated_by")
    var updatedBy: Long? = null

)