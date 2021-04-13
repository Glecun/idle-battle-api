package com.glecun.idlebattleapi.domain.port

import com.glecun.idlebattleapi.domain.entities.UserInfo
import java.util.*

interface UserInfoPort {
    fun findByEmail(email: String): UserInfo?
    fun save(userInfo: UserInfo): UserInfo
    fun findAll(): List<UserInfo>
    fun saveAll(userInfos: List<UserInfo>)
}
