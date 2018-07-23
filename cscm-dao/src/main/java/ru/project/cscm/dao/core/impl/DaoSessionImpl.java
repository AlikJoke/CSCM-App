package ru.project.cscm.dao.core.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ru.project.cscm.dao.config.DaoConfiguration;
import ru.project.cscm.dao.core.DaoSession;
import ru.project.cscm.dao.core.Mapper;

@Repository
@Component
public class DaoSessionImpl implements DaoSession {

	@Resource(name = DaoConfiguration.DataSourceJNDIDictionary.CSCM_DATA_SOURCE)
	private DataSource dataSource;
	
	@PostConstruct
	private void init() {
		initConfiguration();
	}

	private Configuration configuration;

	private void loadMappers() {
		Reflections reflections = new Reflections("ru.project.cscm.dao");
		reflections.getSubTypesOf(Mapper.class).forEach(mapper -> configuration.addMapper(mapper));
	}

	private void initConfiguration() {
		final TransactionFactory transactionFactory = new JdbcTransactionFactory();
		final Environment environment = new Environment("development", transactionFactory, dataSource);
		configuration = new Configuration(environment);
		loadMappers();
		configuration.setLazyLoadingEnabled(true);
	}

	@Override
	public SqlSession getSession(final ExecutorType... type) {
		return type.length == 0 ? new SqlSessionFactoryBuilder().build(configuration).openSession()
				: new SqlSessionFactoryBuilder().build(configuration).openSession(type[0]);
	}

	@Override
	public SqlSession getBatchSession() {
		return new SqlSessionFactoryBuilder().build(configuration).openSession(ExecutorType.BATCH);
	}

	@Override
	public void close(@NotNull final SqlSession session) {
		if (session == null) {
			throw new NullPointerException("Session can't be null");
		}

		session.close();
	}
}
