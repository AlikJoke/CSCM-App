package ru.project.cscm.auth.core.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationManagerImpl implements AuthenticationManager {

	@Autowired
	private AuthenticationProvider provider;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return provider.authenticate(authentication);
	}

}
