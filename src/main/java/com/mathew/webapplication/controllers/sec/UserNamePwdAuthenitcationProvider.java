package com.mathew.webapplication.controllers.sec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component("unpwAuthenticationProvider")
public class UserNamePwdAuthenitcationProvider implements AuthenticationProvider {

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("authenticate of UserNamePwdAuthenitcationProvider");
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		GrantedAuthority[] grantedAuthorities = new GrantedAuthority[] { new SimpleGrantedAuthority("ROLE_SUPERVISOR"),
				new SimpleGrantedAuthority("ROLE_USER") };
		return new UsernamePasswordAuthenticationToken(name, password, Arrays.asList(grantedAuthorities));

	}

	public boolean supports(Class<?> authentication) {
		System.out.println("supports of UserNamePwdAuthenitcationProvider");
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
