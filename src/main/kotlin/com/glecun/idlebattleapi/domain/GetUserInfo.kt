package com.glecun.idlebattleapi.domain;

import com.glecun.idlebattleapi.domain.entities.UserInfo
import com.glecun.idlebattleapi.domain.port.UserInfoPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GetUserInfo @Autowired constructor(val userInfoPort: UserInfoPort) {

    fun execute(email: String): UserInfo {
        return userInfoPort.findByEmail(email) ?: userInfoPort.save(UserInfo.createUserInfo(email))
    }
}
