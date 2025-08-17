package com.LMS.Learning_Management_System.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {
    @Bean
    SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
    	http.formLogin(Customizer.withDefaults());
    	http.httpBasic(Customizer.withDefaults());
    	http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
    	return http.build();
}
    
    @Bean
    BCryptPasswordEncoder pwdEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
