package com.glecun.idlebattleapi.application

import com.glecun.idlebattleapi.domain.ActivateDailyChest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class DailyChestCron @Autowired constructor(val activateDailyChest: ActivateDailyChest) {

    var logger: Logger = LoggerFactory.getLogger(DailyChestCron::class.java)

    @Scheduled(cron="0 0 0 * * *")
    fun dailyChestCron() {
        logger.info("Start dailyChestCron")
        activateDailyChest.execute();
        logger.info("Finish dailyChestCron")
    }
}