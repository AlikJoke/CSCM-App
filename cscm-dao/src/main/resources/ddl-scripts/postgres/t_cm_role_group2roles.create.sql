CREATE TABLE T_CM_ROLE_GROUP2ROLES (
	ROLE_GROUP_ID	NUMERIC(10),
	ROLE_ID			NUMERIC(6)
);

COMMENT ON TABLE 	T_CM_ROLE_GROUP2ROLES 					IS 'This table contains Roles linking to Role Groups';
COMMENT ON COLUMN 	T_CM_ROLE_GROUP2ROLES.ROLE_GROUP_ID 	IS 'Group ID';
COMMENT ON COLUMN 	T_CM_ROLE_GROUP2ROLES.ROLE_ID 			IS 'Role ID';

CREATE UNIQUE INDEX I_CM_RG2ROLES_RGID2RID ON T_CM_ROLE_GROUP2ROLES (ROLE_GROUP_ID, ROLE_ID);

ALTER TABLE T_CM_ROLE_GROUP2ROLES ADD 
	CONSTRAINT PK_CM_ROLE_GROUP2ROLES PRIMARY KEY USING INDEX I_CM_RG2ROLES_RGID2RID;