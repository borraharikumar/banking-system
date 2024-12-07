package com.bank.txn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		return security.csrf(customizer->customizer.disable())
					   .authorizeHttpRequests(customizer->customizer.anyRequest().permitAll())
					   .sessionManagement(customizer->customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
					   .build();
	}

}
