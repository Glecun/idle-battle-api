package com.glecun.idlebattleapi.domain.entities

import java.lang.RuntimeException

data class UserInfo (
        val id: String?,
        val email: String,
        val money: Int,
        val dailyChestRetrieved: Boolean,
        val chestAmount: Int
) {

    fun activateDailyChest(): UserInfo {
        return UserInfo(id, email, money, false, chestAmount);
    }

    fun retrieveDailyChest(): UserInfo {
        if (dailyChestRetrieved) {
            throw RuntimeException("Daily chest already retrieved")
        }
        return UserInfo(id, email, money, true, chestAmount + 1);
    }

    companion object {
        fun createUserInfo(email: String): UserInfo {
            return UserInfo(null, email, 50, false, 0)
        }
    }
}
