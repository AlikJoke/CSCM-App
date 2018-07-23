package ru.project.cscm.auth.core.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import ru.project.cscm.ws_base.utils.Sha512Encoder;

@Component
public class AuthenticationProviderImpl extends AbstractUserDetailsAuthenticationProvider {

	private static final Sha512Encoder encoder = new Sha512Encoder();

	@Autowired
	private UserDetailsService detailsService;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		if (authentication.getCredentials() == null || authentication.getPrincipal() == null) {
			throw new BadCredentialsException(
					messages.getMessage("AuthenticationProvider.badCredentials", "Bad credentials"));
		}

	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		final UserDetails user = detailsService.loadUserByUsername(username);
		if (!user.isEnabled()) {
			throw new DisabledException("User '" + username + "' is disabled");
		}

		if (!encoder.matches((String) authentication.getCredentials(), user.getPassword())) {
			throw new BadCredentialsException("Password is incorrect");
		}

		return user;
	}

}
