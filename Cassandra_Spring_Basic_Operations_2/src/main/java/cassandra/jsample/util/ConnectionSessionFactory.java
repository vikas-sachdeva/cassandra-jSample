package cassandra.jsample.util;

import com.datastax.driver.core.Cluster;

public class ConnectionSessionFactory {

	private Cluster cluster;

	public void connect(String node, int port) {
		this.cluster = Cluster.builder().addContactPoint(node).withPort(port).build();
	}

	
	
	public Cluster getCluster(){
		return this.cluster;
	}

	public void close() {
		cluster.close();
	}
}
