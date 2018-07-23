CREATE TABLE T_CM_USER_STATUS (
	ID   			NUMERIC(2),
	DESCRIPTION  	VARCHAR(100)
);

COMMENT ON TABLE	T_CM_USER_STATUS 				IS 'This table contains user statuses';
COMMENT ON COLUMN	T_CM_USER_STATUS.ID 			IS 'User status ID';
COMMENT ON COLUMN	T_CM_USER_STATUS.DESCRIPTION	IS 'Description';

CREATE UNIQUE INDEX I_CM_USER_STATUS_ID ON T_CM_USER_STATUS (ID);

ALTER TABLE T_CM_USER_STATUS ADD 
	CONSTRAINT PK_CM_USER_STATUS PRIMARY KEY USING INDEX I_CM_USER_STATUS_ID;