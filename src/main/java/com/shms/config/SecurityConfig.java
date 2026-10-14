package com.shms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	public SecurityFilterChain security(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/api/otp/**").permitAll()
						.anyRequest().authenticated()
						)
				.httpBasic(Customizer.withDefaults())
				.build();
		
	}

}
