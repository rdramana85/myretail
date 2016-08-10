package com.target.myretail.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSetFuture;
import com.datastax.driver.core.Session;

@Component
public class DAOImpl implements DAO<Entity> {

	@Autowired
	QueryBuilder<Entity> queryBuilder;

	@Value("${cassandra.ip}")
	private String cassandraIp;

	@Value("${cassandra.port}")
	private String cassandraPort;

	private Session session;

	@Override
	public ResultSetFuture updateAsync(Entity entity) {

		return null;
	}

	@Override
	public ResultSetFuture get(Entity entity) {
		String query = queryBuilder.buildSelectQuery(entity);
		if (session == null) {
			initializeSession();
		}		
		return session.executeAsync(query);
	}

	@Override
	public ResultSetFuture updateAsync(List<Entity> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSetFuture get(List<Entity> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	private void initializeSession() {
		Cluster cluster = Cluster.builder().addContactPoints(cassandraIp)
				.withPort(Integer.parseInt(cassandraPort)).build();
		session = cluster.connect();
	}

}
