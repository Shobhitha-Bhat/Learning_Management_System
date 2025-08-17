package com.LMS.Learning_Management_System.config;

import java.beans.Encoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class MyUserDetails {
	
	@Bean
	UserDetailsService udservice() {
		InMemoryUserDetailsManager udmanager = new InMemoryUserDetailsManager();
		UserDetails user= User
				.withUsername("user")
				.password(passwordEncoder().encode("lmsPortal"))
				.authorities("read").build();
		udmanager.createUser(user);
		return udmanager;
	}
	
	 @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
}
