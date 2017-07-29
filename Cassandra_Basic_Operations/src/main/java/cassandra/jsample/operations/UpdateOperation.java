package cassandra.jsample.operations;

import java.util.UUID;

import com.datastax.driver.core.Session;

import cassandra.jsample.constants.Queries;
import cassandra.jsample.model.Employee;

public class UpdateOperation {

	public void perform(Session session, Employee employeeToUpdate) {

		session.execute(Queries.UPDATE, employeeToUpdate.getEmpname(), employeeToUpdate.getOccupation(),
				employeeToUpdate.getGender(), employeeToUpdate.getDepartment(), employeeToUpdate.getDateofbirth(),
				UUID.fromString(employeeToUpdate.getEmpid()));
	}

}
