package com.glecun.idlebattleapi.domain

import com.glecun.idlebattleapi.domain.port.UserInfoPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RetrieveDailyChest @Autowired constructor(val userInfoPort: UserInfoPort) {

    fun execute(email: String) {
        userInfoPort.findByEmail(email)
                ?.retrieveDailyChest()
                ?.let { userInfoPort.save(it) }
    }
}
