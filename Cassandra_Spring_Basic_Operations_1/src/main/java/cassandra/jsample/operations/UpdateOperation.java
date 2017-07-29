package cassandra.jsample.operations;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;

import cassandra.jsample.constants.Queries;
import cassandra.jsample.model.Employee;

public class UpdateOperation {

	public void perform(Session session, Employee employeeToUpdate) {

		CassandraOperations cassandraOps = new CassandraTemplate(session);

		Statement statement = new SimpleStatement(Queries.UPDATE, employeeToUpdate.getEmpname(),
				employeeToUpdate.getOccupation(), employeeToUpdate.getGender(), employeeToUpdate.getDepartment(),
				employeeToUpdate.getDateofbirth(), employeeToUpdate.getEmpid());

		cassandraOps.execute(statement);

	}
}