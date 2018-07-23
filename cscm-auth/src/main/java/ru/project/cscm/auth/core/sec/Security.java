package ru.project.cscm.auth.core.sec;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * �?нтерфейс входа / выхода в / из системы.
 * 
 * @author Alimurad Ramazanov
 *
 */
public interface Security {

	/**
	 * Авторизация в системе.
	 * <p>
	 * 
	 * @see SecurityContextHolder
	 * @see AuthenticationManager
	 * 
	 * @param username
	 *            - имя пользователя, не может быть {@code null}.
	 * @param password
	 *            - пароль пользователя, не может быть {@code null}.
	 * @throws UsernameNotFoundException
	 */
	String getCurrentUser();

	/**
	 * Выход из системы.
	 * <p>
	 * 
	 * @see SecurityContextHolder
	 * @see AuthenticationManager
	 */
	void logout();
}
