package com.target.myretail.util;

import java.io.IOException;

import org.apache.cassandra.exceptions.ConfigurationException;
import org.apache.thrift.transport.TTransportException;
import org.cassandraunit.CQLDataLoader;
import org.cassandraunit.dataset.cql.ClassPathCQLDataSet;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

@Component
public class EmbeddedDatabase {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedDatabase.class);
	
	@Value("${cassandra.ip}")
	private String cassandraIp;
	
	@Value("${cassandra.port}")
	private String cassandraPort;
	
	@Value("${cassandra.config}")
	private String cassandraConfig;
	
	public void initializeCassandra() throws ConfigurationException, TTransportException, IOException, InterruptedException {
			EmbeddedCassandraServerHelper.startEmbeddedCassandra();
			Cluster cluster = Cluster.builder().addContactPoints(cassandraIp)
			.withPort(Integer.parseInt(cassandraPort)).build();
			Session session = cluster.connect();
			CQLDataLoader dataLoader = new CQLDataLoader(session);
			dataLoader.load(new ClassPathCQLDataSet(cassandraConfig));
	}
	
	public static void tearDown() {
		EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
        EmbeddedCassandraServerHelper.stopEmbeddedCassandra();
    }

}
