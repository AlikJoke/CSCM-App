package ru.project.cscm.auth.core.impl;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ru.project.cscm.auth.core.UserService;
import ru.project.cscm.dao.core.ThreadContext;
import ru.project.cscm.dao.core.mappers.UserMapper;
import ru.project.cscm.dto.items.user.UserItem;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ThreadContext threadContext;

	@Override
	public UserItem getUserByUsername(@NotNull @NotEmpty final String username) {
		if (StringUtils.isEmpty(username)) {
			throw new IllegalArgumentException("Username can't be null or empty");
		}
		
		return threadContext.getSession().getMapper(UserMapper.class).getUserByLogin(username);
	}

}
