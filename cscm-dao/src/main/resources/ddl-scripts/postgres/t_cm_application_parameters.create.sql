CREATE TABLE T_CM_APPLICATION_PARAMETERS (
  	NAME      		VARCHAR(100)      NOT NULL,
  	VALUE           VARCHAR(100)
);

COMMENT ON TABLE 	T_CM_APPLICATION_PARAMETERS 				IS 'This table contains application parameters.';
COMMENT ON COLUMN 	T_CM_APPLICATION_PARAMETERS.NAME	 		IS 'Parameter name';
COMMENT ON COLUMN 	T_CM_APPLICATION_PARAMETERS.VALUE 			IS 'Value of parameter';

CREATE UNIQUE INDEX I_CM_APPL_PARAM_PN ON T_CM_APPLICATION_PARAMETERS (NAME);