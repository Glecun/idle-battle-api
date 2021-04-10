package com.glecun.idlebattleapi.application

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StatusResource {
    @GetMapping("/status")
    fun status(): String {
        return "RUNNING"
    }
}