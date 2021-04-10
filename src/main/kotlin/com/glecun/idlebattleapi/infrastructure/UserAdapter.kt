package com.glecun.idlebattleapi.infrastructure

import com.glecun.farmergameapi.domain.entities.User
import com.glecun.idlebattleapi.domain.port.UserPort
import com.glecun.idlebattleapi.infrastructure.dto.UserMongo
import com.glecun.idlebattleapi.infrastructure.repo.UserMongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*
import java.util.stream.Collectors

@Repository
class UserAdapter @Autowired constructor(val userMongoRepository: UserMongoRepository) : UserPort {

    override fun findByEmail(email: String): User? {
        return userMongoRepository.findByEmail(email)?.toUser()
    }

    override fun save(user: User) {
        userMongoRepository.save(UserMongo.from(user))
    }

    override fun findAll(): List<User> {
        return userMongoRepository.findAll().stream().map(UserMongo::toUser).collect(Collectors.toList())
    }

}
