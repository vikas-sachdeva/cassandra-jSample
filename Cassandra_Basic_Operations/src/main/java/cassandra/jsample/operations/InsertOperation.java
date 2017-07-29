package cassandra.jsample.operations;

import com.datastax.driver.core.Session;

import cassandra.jsample.constants.Queries;
import cassandra.jsample.model.Employee;

public class InsertOperation {

	public void perform(Session session, Employee employeeToAdd) {

		session.execute(Queries.INSERT, employeeToAdd.getEmpname(), employeeToAdd.getOccupation(),
				employeeToAdd.getGender(), employeeToAdd.getDepartment(), employeeToAdd.getDateofbirth());
	}
}