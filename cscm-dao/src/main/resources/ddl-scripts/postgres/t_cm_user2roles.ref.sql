ALTER TABLE T_CM_USER2ROLES ADD CONSTRAINT FK_CM_USER2ROLES_UID 	FOREIGN KEY (USER_ID) 	REFERENCES T_CM_USER (ID)	ON DELETE CASCADE;
ALTER TABLE T_CM_USER2ROLES ADD CONSTRAINT FK_CM_USER2ROLES_RID 	FOREIGN KEY (ROLE_ID) 	REFERENCES T_CM_ROLE (ID);