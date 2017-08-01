package cassandra.jsample.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.keyspace.DropTableSpecification;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

import cassandra.jsample.constants.AppConstants;

@Component
public class DropColumnFamilyOperation {
	
	@Autowired
	private CassandraOperations cassandraOperations;

	public void perform() {

		DropTableSpecification dropTableSpecification = DropTableSpecification.dropTable(AppConstants.COLUMN_FAMILY_NAME);
		
		cassandraOperations.execute(dropTableSpecification);

	}
}