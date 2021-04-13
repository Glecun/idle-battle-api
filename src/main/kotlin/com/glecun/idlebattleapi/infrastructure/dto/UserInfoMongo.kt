package com.glecun.idlebattleapi.infrastructure.dto;

import com.glecun.idlebattleapi.domain.entities.UserInfo
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("userInfo")
data class UserInfoMongo(
        @Id val id: String?,
        val email: String,
        val money: Int,
        val dailyChestRetrieved: Boolean,
        val chestAmount: Int
) {

    companion object {
        fun from(userInfo: UserInfo): UserInfoMongo {
            return UserInfoMongo(userInfo.id, userInfo.email, userInfo.money, userInfo.dailyChestRetrieved, userInfo.chestAmount)
        }
    }

    fun toUserInfo(): UserInfo {
        return UserInfo(id, email, money, dailyChestRetrieved, chestAmount)
    }
}