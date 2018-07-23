package ru.project.cscm.auth.core;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import ru.project.cscm.dto.items.user.UserItem;

/**
 * »нтерфейс взаимодействи€ с пользовательскими данными.
 * 
 * @author Alimurad Ramazanov
 *
 */
public interface UserService {

	/**
	 * ѕолучение пользовател€ по его имени.
	 * <p>
	 * 
	 * @see CscmUser
	 * @param username
	 *            - им€ пользовател€, не может быть {@code null}.
	 * @return может быть {@code null}.
	 */
	UserItem getUserByUsername(@NotNull @NotEmpty String username);
}