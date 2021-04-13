package com.glecun.idlebattleapi.application.dto

import com.glecun.idlebattleapi.domain.entities.UserInfo

data class UserInfoJson(
        val email: String,
        val money: Int,
        val dailyChestRetrieved: Boolean,
        val chestAmount: Int
) {
    companion object {
        fun from(userInfo: UserInfo): UserInfoJson {
            return UserInfoJson(userInfo.email, userInfo.money, userInfo.dailyChestRetrieved, userInfo.chestAmount)
        }
    }
}