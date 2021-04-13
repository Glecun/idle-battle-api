package com.glecun.idlebattleapi.domain

import com.glecun.idlebattleapi.domain.port.UserInfoPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class ActivateDailyChest @Autowired constructor(val userInfoPort: UserInfoPort) {

    fun execute() {
        val userInfos = userInfoPort.findAll().stream()
                .map { userInfo -> userInfo.activateDailyChest() }
                .collect(Collectors.toList())
        userInfoPort.saveAll(userInfos)
    }
}
