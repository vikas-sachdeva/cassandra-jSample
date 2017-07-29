package cassandra.jsample.operations;

import org.springframework.cassandra.core.keyspace.CreateTableSpecification;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.DataType;
import com.datastax.driver.core.Session;

import cassandra.jsample.constants.AppConstants;

public class CreateColumnFamilyOperation {

	public void perform(Cluster cluster) {

		Session session = cluster.connect(AppConstants.NAMESPACE_NAME);

		CassandraOperations cassandraOps = new CassandraTemplate(session);

		CreateTableSpecification createTableSpecification = 	CreateTableSpecification.createTable(AppConstants.COLUMN_FAMILY_NAME)
				.partitionKeyColumn("empid", DataType.uuid()).column("empname", DataType.varchar())
				.column("occupation", DataType.varchar()).column("gender", DataType.varchar())
				.column("department", DataType.varchar()).column("dateofbirth", DataType.date());		

		cassandraOps.execute(createTableSpecification);

	}
}
