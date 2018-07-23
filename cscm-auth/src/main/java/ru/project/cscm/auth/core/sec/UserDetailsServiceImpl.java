package ru.project.cscm.auth.core.sec;

import java.util.function.Function;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ru.project.cscm.auth.core.UserService;
import ru.project.cscm.dto.items.user.UserItem;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	private static final Function<UserItem, UserDetails> userItemToUser = userItem -> User.builder()
			.username(userItem.getLogin()).password(userItem.getPassword()).disabled(!userItem.isActive())
			.authorities(AppRole.ROLE_TRUSTED_CLIENT.name()).build();

	@Override
	public UserDetails loadUserByUsername(@NotEmpty final String username) throws UsernameNotFoundException {
		if (StringUtils.isEmpty(username)) {
			throw new IllegalArgumentException("Username can't be null or empty");
		}

		final UserItem user = userService.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User with username '" + username + "' not found");
		}

		return userItemToUser.apply(user);
	}
}
