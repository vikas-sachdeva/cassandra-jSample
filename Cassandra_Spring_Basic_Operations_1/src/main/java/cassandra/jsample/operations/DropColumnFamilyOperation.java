package cassandra.jsample.operations;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;

import cassandra.jsample.constants.Queries;

public class DropColumnFamilyOperation {

	public void perform(Session session) {

		CassandraOperations cassandraOps = new CassandraTemplate(session);

		cassandraOps.execute(new SimpleStatement(Queries.DROP_COLUMN_FAMILY));

	}
}