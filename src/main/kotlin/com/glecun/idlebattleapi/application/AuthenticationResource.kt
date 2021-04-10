package com.glecun.idlebattleapi.application

import com.glecun.farmergameapi.domain.entities.User
import com.glecun.idlebattleapi.application.dto.UserJson
import com.glecun.idlebattleapi.domain.SignUp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*

@RestController
class AuthenticationResource @Autowired constructor(val signUp: SignUp) {

    @PostMapping("/sign-up")
    fun signUp(@RequestBody user: UserJson) {
        signUp.execute(user.toUser())
    }

    @GetMapping("/sign-in")
    fun signIn(): String {
        return ""
    }

    @RequestMapping(value = ["/user"], method = [RequestMethod.GET])
    @ResponseBody
    fun currentUserName(authentication: Authentication): UserJson {
        val user = authentication.principal as User
        return UserJson.fromUser(user)
    }
}