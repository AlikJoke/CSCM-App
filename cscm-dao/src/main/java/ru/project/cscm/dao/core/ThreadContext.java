package ru.project.cscm.dao.core;

import org.apache.ibatis.session.SqlSession;

public interface ThreadContext {

	SqlSession getSession();

	SqlSession getNewSession();
	
	SqlSession getNewBatchSession();

	SqlSession getBatchSession();
}
