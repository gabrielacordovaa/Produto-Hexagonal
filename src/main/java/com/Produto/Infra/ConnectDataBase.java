package com.Produto.Infra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class ConnectDataBase {
	private Cluster cluster;
	protected Session session;
	
	public void connect(final String node) {
		cluster = Cluster.builder().withoutJMXReporting().addContactPoint(node).build();
		session = cluster.connect();
	}
	
	public void close() {
		cluster.close();
		session.close();
	}
}
