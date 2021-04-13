package com.glecun.idlebattleapi.domain

import com.glecun.idlebattleapi.domain.entities.UserInfo
import com.glecun.idlebattleapi.domain.port.UserInfoPort
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.never
import org.mockito.kotlin.verify


@ExtendWith(MockitoExtension::class)
internal class RetrieveDailyChestTest {
    @Mock
    val userInfoPort: UserInfoPort? = null

    @InjectMocks
    val retrieveDailyChest : RetrieveDailyChest? =null

    @Test
    fun should_retrieve_daily_chest() {
        val email = "greg.lol@mdr.fr"
        `when`(userInfoPort?.findByEmail(email)).thenReturn(
                UserInfo("1", "email", 0, false, 0)
        )

        retrieveDailyChest?.execute(email);

        verify(userInfoPort)?.save(
                UserInfo("1", "email", 0, true, 1)
        )
    }

    @Test
    fun should_not_retrieve_daily_chest_when_daily_chest_already_retrieved() {
        val email = "greg.lol@mdr.fr"
        `when`(userInfoPort?.findByEmail(email)).thenReturn(
                UserInfo("1", "email", 0, true, 0)
        )

        assertThatThrownBy {  retrieveDailyChest?.execute(email) }.isExactlyInstanceOf(RuntimeException::class.java)
    }

    @Test
    fun should_not_retrieve_daily_chest_when_user_info_inexistant() {
        val email = "greg.lol@mdr.fr"
        `when`(userInfoPort?.findByEmail(email)).thenReturn(null)

        retrieveDailyChest?.execute(email)

        verify(userInfoPort, never())?.save(any())
    }
}