package ru.project.cscm.auth.core.sec;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityImpl implements Security {

	@Override
	public String getCurrentUser() {
		return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	@Override
	public void logout() {
		SecurityContextHolder.getContext().getAuthentication().setAuthenticated(false);
		SecurityContextHolder.clearContext();
	}

}
