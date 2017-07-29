package cassandra.jsample.operations;

import org.springframework.cassandra.core.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

import cassandra.jsample.constants.AppConstants;

public class CreateKeyspaceOperation {

	public void perform(Cluster cluster) {

		Session session = cluster.connect();

		CassandraOperations cassandraOps = new CassandraTemplate(session);
		
		CreateKeyspaceSpecification createKeyspaceSpecification = CreateKeyspaceSpecification.createKeyspace(AppConstants.NAMESPACE_NAME).withSimpleReplication(1);

		cassandraOps.execute(createKeyspaceSpecification);

	}
}
