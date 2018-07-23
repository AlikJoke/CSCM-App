package ru.project.cscm.dao.core.impl;

import javax.annotation.PreDestroy;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.project.cscm.dao.core.DaoSession;
import ru.project.cscm.dao.core.ThreadContext;

@Component
@Scope("prototype")
public class ThreadContextImpl implements ThreadContext {

	@Autowired
	private DaoSession session;

	private final ThreadLocal<SqlSession> simpleSession = new ThreadLocal<>();
	private final ThreadLocal<SqlSession> batchSession = new ThreadLocal<>();

	@PreDestroy
	private void close() {
		if (simpleSession.get() != null) {
			session.close(simpleSession.get());
		}

		if (batchSession.get() != null) {
			session.close(batchSession.get());
		}
	}

	@Override
	public SqlSession getSession() {
		if (simpleSession.get() == null) {
			simpleSession.set(session.getSession());
		}

		return simpleSession.get();
	}

	@Override
	public SqlSession getNewSession() {
		simpleSession.set(closeAndGet(false));
		return getSession();
	}

	@Override
	public SqlSession getBatchSession() {
		if (batchSession.get() == null) {
			batchSession.set(session.getBatchSession());
		}

		return batchSession.get();
	}

	@Override
	public SqlSession getNewBatchSession() {
		batchSession.set(closeAndGet(true));
		return getBatchSession();
	}

	private SqlSession closeAndGet(boolean isBatch) {
		final SqlSession result;
		if (isBatch) {
			if (batchSession.get() != null) {
				session.close(batchSession.get());
			}

			result = session.getBatchSession();
		} else {
			if (simpleSession.get() != null) {
				session.close(simpleSession.get());
			}

			result = session.getSession();
		}

		return result;
	}
}
