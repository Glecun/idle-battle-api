package com.glecun.farmergameapi.domain.entities

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

class User(private val username: String, val email: String, private val password: String) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        val simpleGrantedAuthority = SimpleGrantedAuthority("USER")
        return listOf(simpleGrantedAuthority)
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    fun setPassword(encryptedPassword: String): User {
        return User(username, email, encryptedPassword)
    }
}