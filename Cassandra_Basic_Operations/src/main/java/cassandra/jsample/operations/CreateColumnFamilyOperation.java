package cassandra.jsample.operations;

import com.datastax.driver.core.Session;

import cassandra.jsample.constants.Queries;

public class CreateColumnFamilyOperation {

	public void perform(Session session) {
		session.execute(Queries.CREATE_COLUMN_FAMILY);
	}
}
