package com.glecun.idlebattleapi.domain;

import com.glecun.idlebattleapi.domain.port.UserPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.text.MessageFormat

@Service
class CheckUserCredentials(@Autowired val userPort: UserPort) : UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        return userPort.findByEmail(email) ?: throw UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", email))
    }
}