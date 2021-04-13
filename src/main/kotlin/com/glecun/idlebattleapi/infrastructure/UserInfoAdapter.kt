package com.glecun.idlebattleapi.infrastructure

import com.glecun.idlebattleapi.domain.entities.UserInfo
import com.glecun.idlebattleapi.domain.port.UserInfoPort
import com.glecun.idlebattleapi.infrastructure.dto.UserInfoMongo
import com.glecun.idlebattleapi.infrastructure.repo.UserInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.stream.Collectors

@Repository
class UserInfoAdapter @Autowired constructor(val userInfoRepository: UserInfoRepository) : UserInfoPort {

    override fun findByEmail(email: String): UserInfo? {
        return userInfoRepository.findByEmail(email)?.toUserInfo()
    }

    override fun save(userInfo: UserInfo): UserInfo {
        return userInfoRepository.save(UserInfoMongo.from(userInfo)).toUserInfo()
    }

    override fun findAll(): List<UserInfo> {
        return userInfoRepository.findAll().stream().map(UserInfoMongo::toUserInfo).collect(Collectors.toList())
    }

    override fun saveAll(userInfos: List<UserInfo>) {
        val collect = userInfos.stream().map { userInfo -> UserInfoMongo.from(userInfo) }.collect(Collectors.toList())
        userInfoRepository.saveAll(collect)
    }
}