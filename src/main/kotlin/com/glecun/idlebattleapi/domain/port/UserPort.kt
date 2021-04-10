package com.glecun.idlebattleapi.domain.port

import com.glecun.farmergameapi.domain.entities.User

interface UserPort {
    fun findByEmail(email: String): User?
    fun save(user: User)
    fun findAll(): List<User>
}