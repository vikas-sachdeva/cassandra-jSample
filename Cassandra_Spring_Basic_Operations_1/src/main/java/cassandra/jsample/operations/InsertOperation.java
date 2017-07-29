package cassandra.jsample.operations;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;

import cassandra.jsample.constants.Queries;
import cassandra.jsample.model.Employee;

public class InsertOperation {

	public void perform(Session session, Employee employeeToAdd) {

		CassandraOperations cassandraOps = new CassandraTemplate(session);

		Statement statement = new SimpleStatement(Queries.INSERT, employeeToAdd.getEmpname(),
				employeeToAdd.getOccupation(), employeeToAdd.getGender(), employeeToAdd.getDepartment(),
				employeeToAdd.getDateofbirth());

		cassandraOps.execute(statement);
	}
}