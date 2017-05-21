package cassandra.jsample.operations;

import com.datastax.driver.core.Session;

import cassandra.jsample.constants.Queries;

public class DropColumnFamilyOperation {

	public void perform(Session session) {
		session.execute(Queries.DROP_COLUMN_FAMILY);

	}
}
