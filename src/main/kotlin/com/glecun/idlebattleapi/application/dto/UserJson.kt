package com.glecun.idlebattleapi.application.dto

import com.glecun.farmergameapi.domain.entities.User

data class UserJson(val username: String, val email: String, val password: String?) {

    fun toUser(): User {
        return User(username, email, password!!)
    }

    companion object {
        fun fromUser(user: User): UserJson {
            return UserJson(user.username, user.email, null)
        }
    }

}