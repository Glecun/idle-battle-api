package com.glecun.idlebattleapi.infrastructure.repo

import com.glecun.idlebattleapi.infrastructure.dto.UserInfoMongo
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserInfoRepository : MongoRepository<UserInfoMongo, String> {
    fun findByEmail(email: String): UserInfoMongo?
}
