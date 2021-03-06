package ru.project.cscm.dao.core.mappers;

import ru.project.cscm.dao.core.Mapper;

/**
 * Маппер для мониторинга состояния банкоматов.
 * 
 * @author Alimurad Ramazanov
 *
 */
public interface AtmActualStateMapper extends Mapper {
/*
	@ConstructorArgs({ @Arg(column = "STATE", javaType = String.class), @Arg(column = "CITY", javaType = String.class),
			@Arg(column = "STREET", javaType = String.class),
			@Arg(column = "MAIN_CURR_REC_REMAINING", javaType = Integer.class),
			@Arg(column = "SEC_CURR_REC_REMAINING", javaType = Integer.class),
			@Arg(column = "SEC2_CURR_REC_REMAINING", javaType = Integer.class),
			@Arg(column = "SEC3_CURR_REC_REMAINING", javaType = Integer.class),
			@Arg(column = "MAIN_CURR_REMAINING", javaType = Integer.class),
			@Arg(column = "SEC_CURR_REMAINING", javaType = Integer.class),
			@Arg(column = "SEC2_CURR_REMAINING", javaType = Integer.class),
			@Arg(column = "SEC3_CURR_REMAINING", javaType = Integer.class),
			@Arg(column = "MAIN_CURR_CI", javaType = Integer.class),
			@Arg(column = "SEC_CURR_CI", javaType = Integer.class),
			@Arg(column = "SEC2_CURR_CI", javaType = Integer.class),
			@Arg(column = "SEC3_CURR_CI", javaType = Integer.class),
			@Arg(column = "MAIN_CURR_CI_LAST_HOUR_DIFF", javaType = Integer.class),
			@Arg(column = "SEC_CURR_CI_LAST_HOUR_DIFF", javaType = Integer.class),
			@Arg(column = "SEC2_CURR_CI_LAST_HOUR_DIFF", javaType = Integer.class),
			@Arg(column = "SEC3_CURR_CI_LAST_HOUR_DIFF", javaType = Integer.class),
			@Arg(column = "MAIN_CURR_CI_LAST_THREE_HOURS", javaType = Integer.class),
			@Arg(column = "SEC_CURR_CI_LAST_THREE_HOURS", javaType = Integer.class),
			@Arg(column = "SEC2_CURR_CI_LAST_THREE_HOURS", javaType = Integer.class),
			@Arg(column = "SEC3_CURR_CI_LAST_THREE_HOURS", javaType = Integer.class),
			@Arg(column = "MAIN_CURR_CO", javaType = Integer.class),
			@Arg(column = "SEC_CURR_CO", javaType = Integer.class),
			@Arg(column = "SEC2_CURR_CO", javaType = Integer.class),
			@Arg(column = "SEC3_CURR_CO", javaType = Integer.class),
			@Arg(column = "MAIN_CURR_CO_LAST_HOUR_DIFF", javaType = Integer.class),
			@Arg(column = "SEC_CURR_CO_LAST_HOUR_DIFF", javaType = Integer.class),
			@Arg(column = "SEC2_CURR_CO_LAST_HOUR_DIFF", javaType = Integer.class),
			@Arg(column = "SEC3_CURR_CO_LAST_HOUR_DIFF", javaType = Integer.class),
			@Arg(column = "MAIN_CURR_CO_LAST_THREE_HOURS", javaType = Integer.class),
			@Arg(column = "SEC_CURR_CO_LAST_THREE_HOURS", javaType = Integer.class),
			@Arg(column = "SEC2_CURR_CO_LAST_THREE_HOURS", javaType = Integer.class),
			@Arg(column = "SEC3_CURR_CO_LAST_THREE_HOURS", javaType = Integer.class),
			@Arg(column = "CASH_IN_STATE", javaType = Integer.class), @Arg(column = "ATM_ID", javaType = Integer.class),
			@Arg(column = "EXTERNAL_ATM_ID", javaType = String.class),
			@Arg(column = "CASH_IN_BILLS_INITIAL", javaType = Integer.class),
			@Arg(column = "CASH_IN_BILLS_REMAINING", javaType = Integer.class),
			@Arg(column = "REJECT_BILLS_INITIAL", javaType = Integer.class),
			@Arg(column = "REJECT_BILLS_REMAINING", javaType = Integer.class),
			@Arg(column = "MAIN_CURR_CODE", javaType = Integer.class),
			@Arg(column = "MAIN_CODE_A3", javaType = String.class),
			@Arg(column = "SECONDARY_CURR_CODE", javaType = Integer.class),
			@Arg(column = "SECONDARY_CODE_A3", javaType = String.class),
			@Arg(column = "SECONDARY2_CURR_CODE", javaType = Integer.class),
			@Arg(column = "SECONDARY2_CODE_A3", javaType = String.class),
			@Arg(column = "SECONDARY3_CURR_CODE", javaType = Integer.class),
			@Arg(column = "SECONDARY3_CODE_A3", javaType = String.class),
			@Arg(column = "CASH_OUT_STAT_DATE", javaType = Date.class),
			@Arg(column = "STAT_LOAD_DATE", javaType = Date.class),
			@Arg(column = "CASH_OUT_ENC_ID", javaType = Integer.class),
			@Arg(column = "CASH_IN_ENC_ID", javaType = Integer.class),
			@Arg(column = "CASH_IN_R_BILLS_INITIAL", javaType = Integer.class),
			@Arg(column = "OUT_OF_CASH_OUT_CURR", javaType = String.class),
			@Arg(column = "OUT_OF_CASH_OUT_RESP", javaType = Integer.class),
			@Arg(column = "OUT_OF_CASH_OUT_DATE", javaType = Date.class),
			@Arg(column = "OUT_OF_CASH_IN_RESP", javaType = Integer.class),
			@Arg(column = "LAST_WITHDRAWAL_HOURS", javaType = Integer.class),
			@Arg(column = "LAST_ADDITION_HOURS", javaType = Integer.class),
			@Arg(column = "ATM_NAME", javaType = String.class),
			@Arg(column = "DATE_FORTHCOMING_ENCASHMENT", javaType = Date.class),
			@Arg(column = "EMERGENCY_ENCASHMENT", javaType = Boolean.class),
			@Arg(column = "DAYS_UNTIL_ENCASHMENT", javaType = Integer.class),
			@Arg(column = "IS_APPROVED", javaType = Boolean.class),
			@Arg(column = "CURR_REMAINING_ALERT", javaType = Boolean.class),
			@Arg(column = "OUT_OF_CASH_OUT_DATE", javaType = Date.class) })
	@SelectProvider(type = AtmActualStateBuilder.class, method = "builderAtmActualStateQuery")
	@Options(useCache = true, fetchSize = 1000)
	List<AtmActualStateItem> getAtmActualStateList(@Param("addFilter") MonitoringFilter filter);

	@Results({ @Result(property = "amountInit", column = "CASS_INIT", javaType = Integer.class),
			@Result(property = "number", column = "CASS_NUMBER", javaType = Integer.class),
			@Result(property = "denom", column = "CASS_VALUE", javaType = Integer.class),
			@Result(property = "curr", column = "CASS_CURR", javaType = Integer.class),
			@Result(property = "balanceAlert", column = "BALANCE_STATUS", javaType = Boolean.class),
			@Result(property = "amountLeft", column = "CASS_REMAINING", javaType = Integer.class),
			@Result(property = "amountLeftFE", column = "CASS_REMAINING_LOAD", javaType = Integer.class),
			@Result(property = "codeA3", column = "CODE_A3", javaType = String.class),
			@Result(property = "pbClass", column = "CASS_STATE", typeHandler = PbClassHandler.class, javaType = String.class) })
	@Select("select cass.cass_number, cass.cass_value,cs.cass_remaining,cs.cass_curr, en.CASS_COUNT as CASS_INIT, CI.CODE_A3,cass.CASS_STATE, bal.CASS_REMAINING_LOAD, bal.balance_status "
			+ "from T_CM_ATM_CASSETTES cass " + "left outer join T_CM_CASHOUT_CASS_STAT cs on ("
			+ "cs.atm_id = cass.atm_id " + "and cs.cass_number = cass.cass_number "
			+ "and cs.cass_value = cass.cass_value " + "and cs.cass_curr = cass.cass_curr) "
			+ "left outer join T_CM_INTGR_CASS_BALANCE bal on (" + "bal.atm_id = cass.atm_id "
			+ "and bal.cass_number = cass.cass_number) "
			+ "join (select sum(CASS_COUNT) as CASS_COUNT, ENCASHMENT_ID,CASS_NUMBER "
			+ "from T_CM_ENC_CASHOUT_STAT_DETAILS where action_type in (2,4)"
			+ "group by ENCASHMENT_ID,CASS_NUMBER) en on (en.encashment_id = cs.encashment_id and cs.cass_number = en.cass_number) "
			+ "left outer join T_CM_CURR ci on (ci.code_n3 = cass.cass_curr) " + "where  cass.atm_id = #{atmId} "
			+ "AND cass.CASS_TYPE = #{typeId} " + "AND cs.encashment_id = #{encId} " + "AND cs.stat_date = #{statDate} "
			+ "ORDER BY cs.CASS_NUMBER")
	@Options(useCache = true, fetchSize = 1000)
	List<AtmCashOutCassetteItem> getAtmCashOutCassettesList(@Param("atmId") int atmId, @Param("typeId") int typeId,
			@Param("encId") int encId, @Param("statDate") Timestamp statDate);

	@Results({ @Result(property = "amountInit", column = "CASS_INIT", javaType = Integer.class),
			@Result(property = "number", column = "CASS_NUMBER", javaType = Integer.class),
			@Result(property = "denom", column = "CASS_VALUE", javaType = Integer.class),
			@Result(property = "curr", column = "CASS_CURR", javaType = Integer.class),
			@Result(property = "balanceAlert", column = "BALANCE_STATUS", javaType = Boolean.class),
			@Result(property = "amountLeft", column = "CASS_REMAINING", javaType = Integer.class),
			@Result(property = "amountLeftFE", column = "CASS_REMAINING_LOAD", javaType = Integer.class),
			@Result(property = "codeA3", column = "CODE_A3", javaType = String.class),
			@Result(property = "amountIn", column = "CASS_COUNT_IN", javaType = Integer.class),
			@Result(property = "amountOut", column = "CASS_COUNT_OUT", javaType = Integer.class),
			@Result(property = "pbClass", column = "CASS_STATE", typeHandler = PbClassHandler.class, javaType = String.class) })
	@Select("select cass.cass_number, cass.cass_value,csi.cass_remaining," + "sum(cs.CASS_COUNT_IN) as CASS_COUNT_IN,"
			+ "sum(cs.CASS_COUNT_OUT) as CASS_COUNT_OUT," + "cass.cass_curr, en.CASS_COUNT as CASS_INIT, CI.CODE_A3,"
			+ "cass.CASS_STATE, bal.CASS_REMAINING_LOAD, bal.balance_status " + "from T_CM_ATM_CASSETTES cass "
			+ "left outer join (" + "select sum(CASS_COUNT) as CASS_COUNT, CASH_IN_ENCASHMENT_ID,CASS_NUMBER "
			+ "from T_CM_ENC_CASHIN_STAT_DETAILS "
			+ "where action_type in (2,4) and cash_in_encashment_id = #{cachInEncId} "
			+ "group by CASH_IN_ENCASHMENT_ID,CASS_NUMBER) en on (" + "cass.cass_number = en.cass_number) "
			+ "left outer join T_CM_CASHIN_R_CASS_STAT cs on (" + "cs.atm_id = cass.atm_id "
			+ "and cs.cass_number = cass.cass_number " + "and cs.cass_value = cass.cass_value "
			+ "and cs.cass_curr = cass.cass_curr " + "AND cs.cash_in_encashment_id = #{cachInEncId}) "
			+ "left outer join T_CM_INTGR_CASS_BALANCE bal on (" + "bal.atm_id = cass.atm_id "
			+ "and bal.cass_number = cass.cass_number) "
			+ "left outer join T_CM_CURR ci on (ci.code_n3 = cass.cass_curr) "
			+ "left outer join (select CASS_REMAINING,cass_number " + "from T_CM_CASHIN_R_CASS_STAT "
			+ "where  atm_id = #{atmId} " + "AND cash_in_encashment_id = #{cachInEncId} "
			+ "AND stat_date = #{statDate} ) csi on (csi.cass_number = cass.cass_number) "
			+ "where cass.atm_id = #{atmId} " + "AND cass.CASS_TYPE = #{typeId} "
			+ "GROUP BY cass.cass_number, cass.cass_value,csi.cass_remaining,cass.cass_curr, CI.CODE_A3,cass.CASS_TYPE,cass.CASS_STATE,en.CASS_COUNT,bal.balance_status, bal.CASS_REMAINING_LOAD "
			+ "ORDER BY cass.CASS_NUMBER")
	@Options(useCache = true, fetchSize = 1000)
	List<AtmRecyclingCassetteItem> getAtmRecyclingCassettesList(@Param("atmId") int atmId,
			@Param("cachInEncId") int cachInEncId, @Param("statDate") Timestamp statDate, @Param("typeId") int typeId);

	@ConstructorArgs({ @Arg(column = "MAIN_CURR_CODE", javaType = Integer.class),
			@Arg(column = "SECONDARY_CURR_CODE", javaType = Integer.class),
			@Arg(column = "SECONDARY2_CURR_CODE", javaType = Integer.class),
			@Arg(column = "SECONDARY3_CURR_CODE", javaType = Integer.class) })
	@Select("select MAIN_CURR_CODE, SECONDARY_CURR_CODE, SECONDARY2_CURR_CODE, SECONDARY3_CURR_CODE " + "from T_CM_ATM "
			+ "where atm_id = #{atmId}")
	@Options(useCache = true, fetchSize = 1000)
	List<CodesItem> getCurrenciesList(@Param("atmId") int atmId);

	@Results({
			@Result(column = "stat_date", property = "key", typeHandler = ObjectPairHandler.class, javaType = Date.class),
			@Result(column = "enc_id", property = "value", javaType = Integer.class) })
	@Select("select max(stat_date) as stat_date,max(encashment_id) as enc_id " + "from T_CM_CASHOUT_CASS_STAT "
			+ "where atm_id = #{atmId}")
	ObjectPair<Date, Integer> getCashOutLastStat(@Param("atmId") int atmId);

	@Results({
			@Result(column = "stat_date", property = "object", typeHandler = CachOutHoursFromLastWithdrawalHandler.class) })
	@SelectProvider(type = AtmActualStateBuilder.class, method = "getCashOutHoursFromLastWithdrawalBuilder_limit")
	ObjectWrapper<Integer> getCashOutHoursFromLastWithdrawal(@Param("atmId") int atmId, @Param("limit") String limit);

	@Results({
			@Result(column = "stat_date", property = "object", typeHandler = CachOutHoursFromLastWithdrawalHandler.class) })
	@SelectProvider(type = AtmActualStateBuilder.class, method = "getCashInHoursFromLastAdditionBuilder_limit")
	ObjectWrapper<Integer> getCashInHoursFromLastAddition(@Param("atmId") int atmId, @Param("limit") String limit);

	@Results({ @Result(column = "stat_date", property = "key", javaType = Date.class),
			@Result(column = "enc_id", property = "value", javaType = Integer.class) })
	@Select("select max(stat_date) as stat_date,max(encashment_id) as enc_id " + "from T_CM_CASHOUT_CASS_STAT "
			+ "where atm_id = #{atmId}")
	ObjectPair<Date, Integer> getCashInLastStat(@Param("atmId") int atmId);

	@Result(column = "vcheck", javaType = Integer.class)
	@Select("SELECT count(1) as vcheck " + "FROM T_CM_ATM_ACTUAL_STATE " + "where atm_id = #{atmId} ")
	Integer getVCheck(@Param("atmId") int atmId);

	@Insert(" INSERT INTO T_CM_ATM_ACTUAL_STATE (ATM_ID, CASH_OUT_STAT_DATE,CASH_OUT_ENCASHMENT_ID, "
			+ "CASH_IN_STAT_DATE,CASH_IN_ENCASHMENT_ID, LAST_UPDATE,"
			+ "OUT_OF_CASH_OUT_DATE,OUT_OF_CASH_OUT_CURR,OUT_OF_CASH_OUT_RESP,"
			+ "OUT_OF_CASH_IN_DATE,OUT_OF_CASH_IN_RESP, LAST_WITHDRAWAL_HOURS,LAST_ADDITION_HOURS,"
			+ "CURR_REMAINING_ALERT) VALUES (#{atmId, jdbcType=NUMERIC}, #{cashOutStatDate, jdbcType=TIMESTAMP}, #{cashOutStat, jdbcType=INTEGER}, #{cashInStatDate, jdbcType=TIMESTAMP}, "
			+ "#{cashInStat}, #{currTime, jdbcType=INTEGER}, #{outOfCashOutDate, jdbcType=TIMESTAMP}, #{outOfCashOutCurr, jdbcType=INTEGER}, #{outOfCashOutResp, jdbcType=INTEGER}, "
			+ "#{outOfCashInDate}, #{outOfCashInResp, jdbcType=INTEGER}, #{cashOutHoursFromLastWithdrawal, jdbcType=INTEGER}, "
			+ "#{cashInHoursFromLastAddition, jdbcType=INTEGER}, #{needCurrRemainingAlert, jdbcType=INTEGER})")
	void insertAtmActualStateItem(@Param("atmId") int atmId, @Param("cashOutStatDate") Timestamp cashOutStatDate,
			@Param("cashOutStat") Integer cashOutStat, @Param("cashInStatDate") Timestamp cashInStatDate,
			@Param("cashInStat") Integer cashInStat, @Param("currTime") Timestamp currTime,
			@Param("outOfCashOutDate") Timestamp outOfCashOutDate, @Param("outOfCashOutCurr") Integer outOfCashOutCurr,
			@Param("outOfCashOutResp") Integer outOfCashOutResp, @Param("outOfCashInDate") Timestamp outOfCashInDate,
			@Param("outOfCashInResp") Integer outOfCashInResp,
			@Param("cashOutHoursFromLastWithdrawal") Integer cashOutHoursFromLastWithdrawal,
			@Param("cashInHoursFromLastAddition") Integer cashInHoursFromLastAddition,
			@Param("needCurrRemainingAlert") Boolean needCurrRemainingAlert);

	@Insert(" INSERT INTO T_CM_ATM_AVG_DEMAND " + "(ATM_ID, " + "MAIN_CURR_CI, " + "MAIN_CURR_CO, "
			+ "MAIN_CURR_CI_LAST_HOUR_DIFF, " + "MAIN_CURR_CO_LAST_HOUR_DIFF, " + "MAIN_CURR_CI_LAST_THREE_HOURS, "
			+ "MAIN_CURR_CO_LAST_THREE_HOURS, " + "SEC_CURR_CI, " + "SEC_CURR_CO, " + "SEC_CURR_CI_LAST_HOUR_DIFF, "
			+ "SEC_CURR_CO_LAST_HOUR_DIFF, " + "SEC_CURR_CI_LAST_THREE_HOURS, " + "SEC_CURR_CO_LAST_THREE_HOURS, "
			+ "SEC2_CURR_CI, " + "SEC2_CURR_CO, " + "SEC2_CURR_CI_LAST_HOUR_DIFF, " + "SEC2_CURR_CO_LAST_HOUR_DIFF, "
			+ "SEC2_CURR_CI_LAST_THREE_HOURS, " + "SEC2_CURR_CO_LAST_THREE_HOURS " + "SEC3_CURR_CI, " + "SEC3_CURR_CO, "
			+ "SEC3_CURR_CI_LAST_HOUR_DIFF, " + "SEC3_CURR_CO_LAST_HOUR_DIFF, " + "SEC3_CURR_CI_LAST_THREE_HOURS, "
			+ "SEC3_CURR_CO_LAST_THREE_HOURS) "
			+ "VALUES (#{atmId}, #{avgStatRecInCurrLastHourDemand, jdbcType=NUMERIC}, #{avgStatOutLastHourDemand, jdbcType=NUMERIC}, #{mainCurrInDifference, jdbcType=NUMERIC}, "
			+ "#{mainCurrOutDifference, jdbcType=NUMERIC}, #{avgStatRecInCurrLastThreeHoursDemand, jdbcType=NUMERIC}, #{avgStatOutLastThreeHoursDemand, jdbcType=NUMERIC}, #{secCurr1, jdbcType=NUMERIC}, #{secCurr2, jdbcType=NUMERIC}, "
			+ "#{secCurrInDifference, jdbcType=NUMERIC}, #{secCurrOutDifference, jdbcType=NUMERIC}, #{secCurr3, jdbcType=NUMERIC}, #{secCurr4, jdbcType=NUMERIC}, #{sec2Curr1, jdbcType=NUMERIC}, #{sec2Curr2, jdbcType=NUMERIC}, "
			+ "#{sec2CurrInDifference, jdbcType=NUMERIC}, #{sec2CurrOutDifference, jdbcType=NUMERIC}, #{sec2Curr3, jdbcType=NUMERIC}, #{sec2Curr4, jdbcType=NUMERIC}, #{sec3Curr1, jdbcType=NUMERIC}, #{sec3Curr2, jdbcType=NUMERIC}, "
			+ "#{sec3CurrInDifference, jdbcType=NUMERIC}, #{sec3CurrOutDifference, jdbcType=NUMERIC}, #{sec3Curr3, jdbcType=NUMERIC}, #{sec3Curr4, jdbcType=NUMERIC})")
	void insertAtmAvgDemand(@Param("atmId") int atmId,
			@Param("avgStatRecInCurrLastHourDemand") Double avgStatRecInCurrLastHourDemand,
			@Param("avgStatOutLastHourDemand") Double avgStatOutLastHourDemand,
			@Param("mainCurrInDifference") Double mainCurrInDifference,
			@Param("mainCurrOutDifference") Double mainCurrOutDifference,
			@Param("avgStatRecInCurrLastThreeHoursDemand") Double avgStatRecInCurrLastThreeHoursDemand,
			@Param("avgStatOutLastThreeHoursDemand") Double avgStatOutLastThreeHoursDemand,
			@Param("secCurr1") Double secCurr1, @Param("secCurr2") Double secCurr2,
			@Param("secCurrInDifference") Double secCurrInDifference,
			@Param("secCurrOutDifference") Double secCurrOutDifference, @Param("secCurr3") Double secCurr3,
			@Param("secCurr4") Double secCurr4, @Param("sec2Curr1") Double sec2Curr1,
			@Param("sec2Curr2") Double sec2Curr2, @Param("sec2CurrInDifference") Double sec2CurrInDifference,
			@Param("sec2CurrOutDifference") Double sec2CurrOutDifference, @Param("sec2Curr3") Double sec2Curr3,
			@Param("sec2Curr4") Double sec2Curr4, @Param("sec3Curr1") Double sec3Curr1,
			@Param("sec3Curr2") Double sec3Curr2, @Param("sec3CurrInDifference") Double sec3CurrInDifference,
			@Param("sec3CurrOutDifference") Double sec3CurrOutDifference, @Param("sec3Curr3") Double sec3Curr3,
			@Param("sec3Curr4") Double sec3Curr4);

	@Update(" UPDATE T_CM_ATM_ACTUAL_STATE "
			+ "SET CASH_OUT_STAT_DATE = #{cashOutStatDate, jdbcType=DATE}, CASH_OUT_ENCASHMENT_ID = #{cashOutStat}, "
			+ "CASH_IN_STAT_DATE = #{cashInStatDate, jdbcType=DATE}, OUT_OF_CASH_OUT_DATE = #{outOfCashOutCurrDate, jdbcType=DATE}, "
			+ "OUT_OF_CASH_OUT_CURR = #{outOfCashOutCurr, javaType = Integer, jdbcType=INTEGER}, OUT_OF_CASH_OUT_RESP = #{outOfCashOutResp}, "
			+ "OUT_OF_CASH_IN_DATE = #{outOfCashInDate, jdbcType=DATE}, CASH_IN_ENCASHMENT_ID = #{cashInStat}, "
			+ "OUT_OF_CASH_IN_RESP = #{outOfCashInResp}, LAST_WITHDRAWAL_HOURS = #{cashOutHoursFromLastWithdrawal}, LAST_ADDITION_HOURS = #{cashInHoursFromLastAddition}, "
			+ "CURR_REMAINING_ALERT = #{needCurrRemainingAlert} WHERE atm_id = #{atmId} ")
	void updateAtmActualStateItem(@Param("cashOutStatDate") Timestamp cashOutStatDate,
			@Param("cashOutStat") Integer cashOutStat, @Param("cashInStatDate") Timestamp cashInStatDate,
			@Param("cashInStat") Integer cashInStat, @Param("outOfCashOutCurrDate") Timestamp outOfCashOutCurrDate,
			@Param("outOfCashOutCurr") Integer outOfCashOutCurr, @Param("outOfCashOutResp") Integer outOfCashOutResp,
			@Param("outOfCashInDate") Timestamp outOfCashInDate, @Param("outOfCashInResp") Integer outOfCashInResp,
			@Param("cashOutHoursFromLastWithdrawal") Integer cashOutHoursFromLastWithdrawal,
			@Param("cashInHoursFromLastAddition") Integer cashInHoursFromLastAddition,
			@Param("needCurrRemainingAlert") Boolean needCurrRemainingAlert, @Param("atmId") Integer atmId);

	@Update(" UPDATE T_CM_ATM_AVG_DEMAND SET MAIN_CURR_CI = #{mainCurr1, jdbcType=NUMERIC}, MAIN_CURR_CO = #{mainCurr2, jdbcType=NUMERIC}, "
			+ "MAIN_CURR_CI_LAST_HOUR_DIFF = #{mainCurr3, jdbcType=NUMERIC}, MAIN_CURR_CO_LAST_HOUR_DIFF = #{mainCurr4, jdbcType=NUMERIC}, "
			+ "MAIN_CURR_CI_LAST_THREE_HOURS = #{mainCurr5, jdbcType=NUMERIC}, MAIN_CURR_CO_LAST_THREE_HOURS = #{mainCurr6, jdbcType=NUMERIC}, SEC_CURR_CI = #{secCurr1, jdbcType=NUMERIC}, "
			+ "SEC_CURR_CO = #{secCurr2, jdbcType=NUMERIC}, SEC_CURR_CI_LAST_HOUR_DIFF = #{secCurr3, jdbcType=NUMERIC}, SEC_CURR_CO_LAST_HOUR_DIFF = #{secCurr4, jdbcType=NUMERIC}, "
			+ "SEC_CURR_CI_LAST_THREE_HOURS = #{secCurr5, jdbcType=NUMERIC}, SEC_CURR_CO_LAST_THREE_HOURS = #{secCurr6, jdbcType=NUMERIC}, SEC2_CURR_CI = #{sec2Curr1, jdbcType=NUMERIC}, "
			+ "SEC2_CURR_CO = #{sec2Curr2, jdbcType=NUMERIC}, SEC2_CURR_CI_LAST_HOUR_DIFF = #{sec2Curr3, jdbcType=NUMERIC}, SEC2_CURR_CO_LAST_HOUR_DIFF = #{sec2Curr4, jdbcType=NUMERIC}, "
			+ "SEC2_CURR_CI_LAST_THREE_HOURS = #{sec2Curr5, jdbcType=NUMERIC}, SEC2_CURR_CO_LAST_THREE_HOURS = #{sec2Curr6, jdbcType=NUMERIC}, SEC3_CURR_CI = #{sec3Curr1, jdbcType=NUMERIC}, "
			+ "SEC3_CURR_CO = #{sec3Curr2, jdbcType=NUMERIC}, SEC3_CURR_CI_LAST_HOUR_DIFF = #{sec3Curr3, jdbcType=NUMERIC}, SEC3_CURR_CO_LAST_HOUR_DIFF = #{sec3Curr4, jdbcType=NUMERIC}, "
			+ "SEC3_CURR_CI_LAST_THREE_HOURS = #{sec3Curr5, jdbcType=NUMERIC}, SEC3_CURR_CO_LAST_THREE_HOURS = #{sec3Curr6, jdbcType=NUMERIC} "
			+ "WHERE atm_id = #{atmId} ")
	void updateAtmAvgDemand(@Param("mainCurr1") Double mainCurr1, @Param("mainCurr2") Double mainCurr2,
			@Param("mainCurr3") Double mainCurr3, @Param("mainCurr4") Double mainCurr4,
			@Param("mainCurr5") Double mainCurr5, @Param("mainCurr6") Double mainCurr6,
			@Param("secCurr1") Double secCurr1, @Param("secCurr2") Double secCurr2, @Param("secCurr3") Double secCurr3,
			@Param("secCurr4") Double secCurr4, @Param("secCurr5") Double secCurr5, @Param("secCurr6") Double secCurr6,
			@Param("sec2Curr1") Double sec2Curr1, @Param("sec2Curr2") Double sec2Curr2,
			@Param("sec2Curr3") Double sec2Curr3, @Param("sec2Curr4") Double sec2Curr4,
			@Param("sec2Curr5") Double sec2Curr5, @Param("sec2Curr6") Double sec2Curr6,
			@Param("sec3Curr1") Double sec3Curr1, @Param("sec3Curr2") Double sec3Curr2,
			@Param("sec3Curr3") Double sec3Curr3, @Param("sec3Curr4") Double sec3Curr4,
			@Param("sec3Curr5") Double sec3Curr5, @Param("sec3Curr6") Double sec3Curr6, @Param("atmId") Integer atmId);

	@Update("UPDATE T_CM_ATM_ACTUAL_STATE " + "SET " + "LAST_UPDATE = #{lastUpdate} " + "WHERE atm_id = #{atmId} ")
	void updateAtmActualState(@Param("lastUpdate") Timestamp lastUpdate, @Param("atmId") Integer atmId);

	@Update("UPDATE T_CM_ATM_ACTUAL_STATE SET CASH_IN_INITIAL = #{cashInVolume}, REJECT_INITIAL = #{rejectVolume}, "
			+ "CASH_IN_R_INITIAL = #{cashInRVolume} " + "WHERE atm_id = #{atmId} ")
	void updateInitialsForAtm(@Param("cashInVolume") Integer cashInVolume, @Param("rejectVolume") Integer rejectVolume,
			@Param("cashInRVolume") Integer cashInRVolume, @Param("atmId") Integer atmId);

	@Result(column = "vcheck", javaType = Integer.class)
	@Select("SELECT count(1) as vcheck " + "FROM T_CM_ATM_ACTUAL_STATE")
	Integer checkAtmActStateTable();

	@Results({ @Result(column = "CASS_NUMBER", property = "number", javaType = Integer.class),
			@Result(column = "CASS_VALUE", property = "denom", javaType = Integer.class),
			@Result(column = "CASS_CURR", property = "curr", javaType = Integer.class),
			@Result(column = "CASS_CAPACITY", property = "capacity", javaType = Integer.class) })
	@Select("SELECT distinct cstat.CASS_NUMBER,cstat.CASS_VALUE,cstat.CASS_CURR,NVL(cass.CASS_CAPACITY,0) as CASS_CAPACITY "
			+ "FROM T_CM_CASHOUT_CASS_STAT cstat "
			+ "left outer join T_CM_ATM_CASSETTES cass on (cstat.atm_id=cass.atm_id and cstat.cass_number=cass.cass_number and cass.cass_type=#{typeId}) "
			+ "WHERE cstat.encashment_id = #{encId} and cstat.atm_id = #{atmId} ")
	@Options(useCache = true, fetchSize = 1000)
	List<AtmCassetteItem> getCashOutCassettes(@Param("typeId") Integer typeId, @Param("encId") Integer encId,
			@Param("atmId") Integer atmId, ResultHandler<AtmCassetteItem> handler);

	@Results({ @Result(column = "CASS_NUMBER", property = "number", javaType = Integer.class),
			@Result(column = "CASS_VALUE", property = "denom", javaType = Integer.class),
			@Result(column = "CASS_CURR", property = "curr", javaType = Integer.class),
			@Result(column = "CASS_CAPACITY", property = "capacity", javaType = Integer.class) })
	@Select("SELECT distinct cstat.CASS_NUMBER,cstat.CASS_VALUE,cstat.CASS_CURR,NVL(cass.CASS_CAPACITY,0) as CASS_CAPACITY "
			+ "FROM T_CM_CASHIN_R_CASS_STAT cstat "
			+ "left outer join T_CM_ATM_CASSETTES cass on (cstat.atm_id=cass.atm_id and cstat.cass_number=cass.cass_number and cass.cass_type=#{typeId}) "
			+ "WHERE cstat.cash_in_encashment_id = #{encId} and cstat.atm_id = #{atmId} ")
	@Options(useCache = true, fetchSize = 1000)
	List<AtmCassetteItem> getCashInRecyclingCassettes(@Param("typeId") Integer typeId, @Param("encId") Integer encId,
			@Param("atmId") Integer atmId, ResultHandler<AtmCassetteItem> handler);

	@Result(column = "vcheck", javaType = Integer.class)
	@Select("SELECT count(1) as vcheck FROM T_CM_ATM_CASSETTES where ATM_ID = #{atmId} "
			+ "AND CASS_TYPE = #{cassType} AND CASS_NUMBER = #{cassNumber} ")
	Integer checkAtmCassettes(@Param("atmId") Integer atmId, @Param("cassType") Integer cassType,
			@Param("cassNumber") Integer cassNumber);

	@Insert(" INSERT INTO T_CM_ATM_CASSETTES (ATM_ID, CASS_TYPE, CASS_NUMBER, CASS_CURR, CASS_VALUE) VALUES "
			+ "(#{atmId}, #{typeId}, #{cassNumber}, #{curr}, #{denom})")
	void insertAtmCassettes(@Param("atmId") Integer atmId, @Param("typeId") Integer typeId,
			@Param("cassNumber") Integer cassNumber, @Param("curr") Integer curr, @Param("denom") Integer denom);

	@Insert(" UPDATE T_CM_ATM_CASSETTES " + "SET CASS_CURR = #{curr} , " + "CASS_VALUE = #{denom} " + "where "
			+ "ATM_ID = #{atmId} " + "AND CASS_TYPE = #{typeId} " + "AND CASS_NUMBER = #{cassNumber} ")
	void updateAtmCassettes(@Param("atmId") Integer atmId, @Param("typeId") Integer typeId,
			@Param("cassNumber") Integer cassNumber, @Param("curr") Integer curr, @Param("denom") Integer denom);

	@Delete("DELETE FROM T_CM_ATM_CASSETTES " + "where " + "ATM_ID = #{atmId} " + "AND COALESCE(CASS_CURR,0) = 0 ")
	void deleteAtmCassettes(@Param("atmId") Integer atmId);

	@Update("update t_cm_intgr_cass_balance intbal SET CASS_REMAINING_CALC = ( "
			+ "select cs.cass_remaining from t_cm_cashout_cass_stat cs where  "
			+ "cs.atm_id = intbal.atm_id and cs.cass_number = intbal.cass_number and "
			+ "cs.encashment_id = (select CASH_OUT_ENCASHMENT_ID from t_cm_atm_actual_state where atm_id = intbal.atm_id) "
			+ "and "
			+ "cs.stat_date = (select CASH_OUT_STAT_DATE from t_cm_atm_actual_state where atm_id = intbal.atm_id) "
			+ ") WHERE intbal.cass_type = #{cassType} ")
	void updateCalculatedRemainingForAtms1(@Param("cassType") Integer cassType);

	@Update("update t_cm_intgr_cass_balance intbal " + "SET CASS_REMAINING_CALC =  " + "(  "
			+ "select cs.cass_remaining " + "from " + "t_cm_cashin_r_cass_stat cs " + "where  "
			+ "cs.atm_id = intbal.atm_id " + "and " + "cs.cass_number = intbal.cass_number " + "and "
			+ "cs.cash_in_encashment_id = (select CASH_IN_ENCASHMENT_ID from t_cm_atm_actual_state where atm_id = intbal.atm_id) "
			+ "and "
			+ "cs.stat_date = (select CASH_IN_STAT_DATE from t_cm_atm_actual_state where atm_id = intbal.atm_id) "
			+ ") " + "WHERE " + "intbal.cass_type = #{cassType} ")
	void updateCalculatedRemainingForAtms2(@Param("cassType") Integer cassType);

	@Update("update t_cm_intgr_cass_balance intbal " + "SET CASS_REMAINING_CALC =  " + "(  "
			+ "select cs.cass_remaining " + "from " + "t_cm_cashin_r_cass_stat cs " + "where  "
			+ "cs.atm_id = intbal.atm_id " + "and " + "cs.cass_number = intbal.cass_number " + "and "
			+ "cs.cash_in_encashment_id = (select CASH_IN_ENCASHMENT_ID from t_cm_atm_actual_state where atm_id = intbal.atm_id) "
			+ "and "
			+ "cs.stat_date = (select CASH_IN_STAT_DATE from t_cm_atm_actual_state where atm_id = intbal.atm_id) "
			+ ") " + "WHERE " + "intbal.cass_type = #{cassType} ")
	void updateCalculatedRemainingForAtms3(@Param("cassType") Integer cassType);

	@ConstructorArgs({ @Arg(column = "ATM_ID", javaType = Integer.class),
			@Arg(column = "CASS_TYPE", javaType = Integer.class),
			@Arg(column = "CASS_NUMBER", javaType = Integer.class),
			@Arg(column = "CASS_REMAINING_LOAD", javaType = Integer.class),
			@Arg(column = "CASS_REMAINING_CALC", javaType = Integer.class) })
	@Select("select ATM_ID, CASS_TYPE, CASS_NUMBER, CASS_REMAINING_LOAD, CASS_REMAINING_CALC "
			+ "from t_cm_intgr_cass_balance "
			+ "WHERE abs(COALESCE(CASS_REMAINING_LOAD,0) - COALESCE(CASS_REMAINING_CALC,0)) > #{threshhold} "
			+ " AND BALANCE_STATUS <> 1 " + "ORDER BY ATM_ID, CASS_TYPE, CASS_NUMBER")
	List<BalanceItem> checkLoadedBalances1(@Param("threshhold") Integer threshhold);

	@ConstructorArgs({ @Arg(column = "ATM_ID", javaType = Integer.class),
			@Arg(column = "CASS_TYPE", javaType = Integer.class),
			@Arg(column = "CASS_NUMBER", javaType = Integer.class),
			@Arg(column = "CASS_REMAINING_LOAD", javaType = Integer.class),
			@Arg(column = "CASS_REMAINING_CALC", javaType = Integer.class) })
	@SelectProvider(type = AtmActualStateBuilder.class, method = "builderQueryCheckLoadedBalances")
	List<BalanceItem> checkLoadedBalances2(@Param("threshhold") Integer threshhold,
			@Param("atmsList") List<Integer> atmsList);

	@Result(column = "ATM_STATE", javaType = Integer.class)
	@SelectProvider(type = AtmActualStateBuilder.class, method = "getAtmDeviceStateBuilder_limit")
	Integer getAtmDeviceState(@Param("atmId") Integer atmId, @Param("limit") String limit);
*/
}
