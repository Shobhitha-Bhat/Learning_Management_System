package com.LMS.Learning_Management_System.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Configuration
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String pwd=authentication.getCredentials().toString();
		
		if("user".equals(username) && "lmsPortal".equals(pwd)) {
			return new UsernamePasswordAuthenticationToken(username, pwd,List.of(new SimpleGrantedAuthority("read")));
		}
		else {
			throw new BadCredentialsException("Invalid Credentials");
		}
//		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);

	}
	
}
