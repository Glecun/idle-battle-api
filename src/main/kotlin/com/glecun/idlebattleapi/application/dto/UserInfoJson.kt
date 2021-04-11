package com.glecun.idlebattleapi.application.dto

import com.glecun.idlebattleapi.domain.entities.UserInfo
import java.util.stream.Collectors

data class UserInfoJson(val email: String, val money: Number) {
    companion object {
        fun from(userInfo: UserInfo): UserInfoJson {
            return UserInfoJson(userInfo.email, userInfo.money)
        }
    }
}