package cassandra.jsample.operations;

import java.util.UUID;

import com.datastax.driver.core.Session;

import cassandra.jsample.constants.Queries;

public class DeleteOperation {

	public void perform(Session session, String employeeIdToBeDeleted) {
		session.execute(Queries.DELETE, UUID.fromString(employeeIdToBeDeleted));
	}
}
