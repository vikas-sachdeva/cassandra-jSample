package cassandra.jsample.operations;

import java.util.Calendar;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.Session;

import cassandra.jsample.constants.Queries;
import cassandra.jsample.model.Employee;

public class InsertOperation {

	public void perform(Session session, Employee employeeToAdd) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(employeeToAdd.getDateofbirth());

		LocalDate localDate = LocalDate.fromYearMonthDay(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));

		session.execute(Queries.INSERT, employeeToAdd.getEmpname(), employeeToAdd.getOccupation(),
				employeeToAdd.getGender(), employeeToAdd.getDepartment(), localDate);
	}
}