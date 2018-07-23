package ru.project.cscm.auth.core;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import ru.project.cscm.dto.items.user.UserItem;

/**
 * ��������� �������������� � ����������������� �������.
 * 
 * @author Alimurad Ramazanov
 *
 */
public interface UserService {

	/**
	 * ��������� ������������ �� ��� �����.
	 * <p>
	 * 
	 * @see CscmUser
	 * @param username
	 *            - ��� ������������, �� ����� ���� {@code null}.
	 * @return ����� ���� {@code null}.
	 */
	UserItem getUserByUsername(@NotNull @NotEmpty String username);
}