package cassandra.jsample.operations;

import org.springframework.cassandra.core.keyspace.DropKeyspaceSpecification;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

import cassandra.jsample.constants.AppConstants;

public class DropKeyspaceOperation {

	public void perform(Cluster cluster) {

		Session session = cluster.connect();

		CassandraOperations cassandraOps = new CassandraTemplate(session);

		DropKeyspaceSpecification dropKeyspaceSpecification = new DropKeyspaceSpecification(
				AppConstants.NAMESPACE_NAME);

		cassandraOps.execute(dropKeyspaceSpecification);

	}
}
