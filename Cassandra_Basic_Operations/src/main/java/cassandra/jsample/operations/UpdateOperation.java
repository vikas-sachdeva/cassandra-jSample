package cassandra.jsample.operations;

import java.util.Calendar;
import java.util.UUID;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.Session;

import cassandra.jsample.constants.Queries;
import cassandra.jsample.model.Employee;


public class UpdateOperation {

	public void perform(Session session, Employee employeeToUpdate) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(employeeToUpdate.getDateofbirth());

		LocalDate localDate = LocalDate.fromYearMonthDay(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));

		session.execute(Queries.UPDATE, employeeToUpdate.getEmpname(), employeeToUpdate.getOccupation(),
				employeeToUpdate.getGender(), employeeToUpdate.getDepartment(), localDate,
				UUID.fromString(employeeToUpdate.getEmpid()));
	}

}
