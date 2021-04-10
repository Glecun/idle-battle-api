package com.glecun.idlebattleapi.domain

import com.glecun.farmergameapi.domain.entities.User
import com.glecun.idlebattleapi.domain.port.UserPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.text.MessageFormat
import java.util.regex.Pattern

@Service
class SignUp @Autowired constructor(val userPort: UserPort) {
    private val bCryptPasswordEncoder = BCryptPasswordEncoder()

    fun execute(user: User) {
        if (!isValidEmailAddress(user.email)) {
            throw RuntimeException(MessageFormat.format("Email: {0} isn't valid", user.email))
        }
        if (!isUsernameNotTooLong(user.username)) {
            throw RuntimeException(MessageFormat.format("Email: {0} isn't valid", user.email))
        }
        val encryptedPassword = bCryptPasswordEncoder.encode(user.password)
        userPort.findByEmail(user.email)
                ?.let{ existingUser -> throw RuntimeException(MessageFormat.format("User with email: {0} already exists", existingUser.email))}
                ?: userPort.save(user.setPassword(encryptedPassword))
    }

    private fun isUsernameNotTooLong(username: String): Boolean {
        return username.length <= 20
    }

    fun isValidEmailAddress(email: String?): Boolean {
        val ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"
        val p = Pattern.compile(ePattern)
        val m = p.matcher(email)
        return m.matches()
    }
}
