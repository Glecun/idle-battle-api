package com.glecun.idlebattleapi.application

import com.glecun.farmergameapi.domain.entities.User
import com.glecun.idlebattleapi.application.dto.UserInfoJson
import com.glecun.idlebattleapi.domain.GetUserInfo
import com.glecun.idlebattleapi.domain.RetrieveDailyChest
import com.glecun.idlebattleapi.domain.SignUp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user-info")
class UserInfoResource @Autowired constructor(
        val getUserInfo: GetUserInfo,
        val retrieveDailyChest: RetrieveDailyChest
) {

    @GetMapping("/")
    fun getUserInfo(authentication: Authentication): UserInfoJson? {
        val user = authentication.principal as User
        return UserInfoJson.from(getUserInfo.execute(user.email))
    }

    @GetMapping("/daily-chest")
    fun getDailyChest(authentication: Authentication) {
        val user = authentication.principal as User
        retrieveDailyChest.execute(user.email)
    }

}