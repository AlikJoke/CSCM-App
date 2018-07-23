CREATE TABLE T_CM_USER2ATM_GROUPS (
	USER_ID      	NUMERIC(10),
	ATM_GROUP_ID  	NUMERIC(10)
);

COMMENT ON TABLE 	T_CM_USER2ATM_GROUPS 				IS 'Table for linking users and ATM groups';
COMMENT ON COLUMN 	T_CM_USER2ATM_GROUPS.USER_ID 		IS 'User ID';
COMMENT ON COLUMN 	T_CM_USER2ATM_GROUPS.ATM_GROUP_ID 	IS 'ATM Group ID';

CREATE UNIQUE INDEX I_CM_USER2AG_UID2GID ON T_CM_USER2ATM_GROUPS (USER_ID, ATM_GROUP_ID);

ALTER TABLE T_CM_USER2ATM_GROUPS ADD
	CONSTRAINT PK_CM_USER2ATM_GROUPS PRIMARY KEY USING INDEX I_CM_USER2AG_UID2GID;

