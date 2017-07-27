package cassandra.jsample.operations;

import java.util.UUID;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;

import cassandra.jsample.constants.Queries;

public class DeleteOperation {

	public void perform(Session session, UUID employeeIdToBeDeleted) {

		CassandraOperations cassandraOps = new CassandraTemplate(session);

		Statement statement = new SimpleStatement(Queries.DELETE, employeeIdToBeDeleted);

		cassandraOps.execute(statement);

	}
}
