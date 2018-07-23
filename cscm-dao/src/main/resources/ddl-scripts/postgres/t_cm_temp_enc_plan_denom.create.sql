CREATE TEMPORARY TABLE t_cm_temp_enc_plan_denom
    (enc_plan_id                    NUMERIC(6) NOT NULL,
    denom_value                    NUMERIC(6) NOT NULL,
    denom_count                    NUMERIC(4) NOT NULL,
    denom_curr                     NUMERIC(3) NOT NULL)
ON COMMIT DELETE ROWS;

COMMENT ON TABLE t_cm_temp_enc_plan_denom IS 'This table contains list of denominations that would be loaded on replenishment generated by forecasting for user-defined date. If there are two records with the same denomination for one replenishment - that means that count of this denomination was splitted into several cassettes as there were empty cassettes after forecasting.';
COMMENT ON COLUMN t_cm_temp_enc_plan_denom.denom_count IS 'Denomination count';
COMMENT ON COLUMN t_cm_temp_enc_plan_denom.denom_curr IS 'Denomination currency';
COMMENT ON COLUMN t_cm_temp_enc_plan_denom.denom_value IS 'Denomination';
COMMENT ON COLUMN t_cm_temp_enc_plan_denom.enc_plan_id IS 'Planned replenishment ID';
