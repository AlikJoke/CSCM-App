package ru.project.cscm.auth.core.sec;

/**
 * Перечисление ролей пользователей в приложении.
 * 
 * @author Alimurad Ramazanov
 *
 */
public enum AppRole {

	/**
	 * Пользователь
	 */
	ROLE_CLIENT,

	/**
	 * Доверенный пользователь
	 */
	ROLE_TRUSTED_CLIENT,

	/**
	 * Администратор
	 */
	ROLE_ADMIN,

	/**
	 * Аналитик
	 */
	ROLE_ANALYST;
}
