package com.glecun.idlebattleapi.infrastructure.repo

import com.glecun.idlebattleapi.infrastructure.dto.UserMongo
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface UserMongoRepository : MongoRepository<UserMongo, String> {
    fun findByEmail(email: String): UserMongo?
}
