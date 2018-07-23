CREATE TABLE T_CM_USER2INSTS (
	USER_ID	NUMERIC(10),
	INST_ID	VARCHAR(4)
);

COMMENT ON TABLE 	T_CM_USER2INSTS 			IS 'Table for linking users and institutes';
COMMENT ON COLUMN 	T_CM_USER2INSTS.USER_ID 	IS 'User ID';
COMMENT ON COLUMN 	T_CM_USER2INSTS.INST_ID 	IS 'Institute ID';

CREATE UNIQUE INDEX I_CM_USER2INSTS_UID2IID ON T_CM_USER2INSTS (USER_ID, INST_ID);

ALTER TABLE T_CM_USER2INSTS ADD 
	CONSTRAINT PK_CM_USER2INSTS PRIMARY KEY USING INDEX I_CM_USER2INSTS_UID2IID;