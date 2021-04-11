package com.glecun.idlebattleapi.domain.entities

data class UserInfo (val id: String?, val email: String, val money: Number) {

    companion object {
        fun createUserInfo(email: String): UserInfo {
            return UserInfo(null, email, 50)
        }
    }
}
