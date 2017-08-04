package cassandra.jsample.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.keyspace.CreateTableSpecification;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.DataType;

import cassandra.jsample.constants.AppConstants;

@Component
public class CreateColumnFamilyOperation {

	@Autowired
	private CassandraOperations cassandraOperations;

	public void perform() {

		CreateTableSpecification createTableSpecification = CreateTableSpecification
				.createTable(AppConstants.COLUMN_FAMILY_NAME).partitionKeyColumn("empid", DataType.uuid())
				.column("empname", DataType.varchar()).column("occupation", DataType.varchar())
				.column("gender", DataType.varchar()).column("department", DataType.varchar())
				.column("dateofbirth", DataType.date());

		cassandraOperations.execute(createTableSpecification);

	}
}
