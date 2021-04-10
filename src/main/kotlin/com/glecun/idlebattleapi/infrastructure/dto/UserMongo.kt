package com.glecun.idlebattleapi.infrastructure.dto

import com.glecun.farmergameapi.domain.entities.User
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("user")
class UserMongo(val username: String, val email: String, val password: String) {
    @Id
    var id: String? = null;

    companion object {
        fun from(user: User): UserMongo {
            return UserMongo(user.username, user.email, user.password)
        }
    }

    fun toUser(): User {
        return User(username, email, password)
    }

}
