package com.glecun.idlebattleapi.domain

import com.glecun.idlebattleapi.domain.entities.UserInfo
import com.glecun.idlebattleapi.domain.port.UserInfoPort
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class GetUserInfoTest {
    @Mock
    val userInfoPort: UserInfoPort? = null

    @InjectMocks
    val getUserInfo : GetUserInfo? =null

    @Test
    fun should_create_default_user_info_when_inexistant() {
        val email = "greg.lol@mdr.fr"
        Mockito.`when`(userInfoPort?.findByEmail(email)).thenReturn(null)

        getUserInfo?.execute(email);

        Mockito.verify(userInfoPort)?.save(UserInfo(null, email, 50))
    }
}