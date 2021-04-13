package com.glecun.idlebattleapi.domain

import com.glecun.idlebattleapi.domain.entities.UserInfo
import com.glecun.idlebattleapi.domain.port.UserInfoPort
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.List.of

@ExtendWith(MockitoExtension::class)
internal class ActivateDailyChestTest {

    @Mock
    val userInfoPort: UserInfoPort? = null

    @InjectMocks
    val activateDailyChest : ActivateDailyChest? =null

    @Test
    fun should_activate_Daily_Chest() {
        Mockito.`when`(userInfoPort?.findAll()).thenReturn(listOf(
                UserInfo("1", "email", 0, false, 0),
                UserInfo("2", "email", 0, true, 0)
        ))

        activateDailyChest?.execute();

        Mockito.verify(userInfoPort)?.saveAll(listOf(
                UserInfo("1", "email", 0, false, 0),
                UserInfo("2", "email", 0, false, 0)
        ))
    }
}