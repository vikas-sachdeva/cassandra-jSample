package cassandra.jsample.operations;

import org.springframework.cassandra.core.keyspace.DropTableSpecification;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

import cassandra.jsample.constants.AppConstants;

public class DropColumnFamilyOperation {

	public void perform(Cluster cluster) {

		Session session = cluster.connect(AppConstants.NAMESPACE_NAME);

		CassandraOperations cassandraOps = new CassandraTemplate(session);

		DropTableSpecification dropTableSpecification = DropTableSpecification.dropTable(AppConstants.COLUMN_FAMILY_NAME);
		
		cassandraOps.execute(dropTableSpecification);

	}
}