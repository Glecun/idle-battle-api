package com.glecun.idlebattleapi

import com.glecun.idlebattleapi.domain.CheckUserCredentials
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@SpringBootApplication
@EnableScheduling
class IdleBattleApiApplication

fun main(args: Array<String>) {
	runApplication<IdleBattleApiApplication>(*args)
}

@Configuration
@EnableWebSecurity
class WebSecurityConfig(@Autowired val checkUserCredentials: CheckUserCredentials) : WebSecurityConfigurerAdapter() {

	override fun configure(http: HttpSecurity) {
		http
				.cors().and().csrf().disable()
				.httpBasic().and()
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers(HttpMethod.GET, "/status").permitAll()
				.antMatchers(HttpMethod.POST, "/sign-up").permitAll()
				.anyRequest()
				.authenticated()
	}

	@Bean
	fun corsConfigurationSource(): CorsConfigurationSource {
		val source = UrlBasedCorsConfigurationSource()
		source.registerCorsConfiguration("/**", CorsConfiguration().applyPermitDefaultValues())
		return source
	}

	@Autowired
	fun configureGlobal(auth: AuthenticationManagerBuilder) {
		auth.userDetailsService<UserDetailsService>(checkUserCredentials).passwordEncoder(BCryptPasswordEncoder())
	}

}