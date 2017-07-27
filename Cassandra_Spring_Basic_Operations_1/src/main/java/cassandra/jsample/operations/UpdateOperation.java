package cassandra.jsample.operations;

import java.util.Calendar;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;

import cassandra.jsample.constants.Queries;
import cassandra.jsample.model.Employee;

public class UpdateOperation {

	public void perform(Session session, Employee employeeToUpdate) {

		CassandraOperations cassandraOps = new CassandraTemplate(session);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(employeeToUpdate.getDateofbirth());

		LocalDate localDate = LocalDate.fromYearMonthDay(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
				calendar.get(Calendar.DAY_OF_MONTH));

		Statement statement = new SimpleStatement(Queries.UPDATE, employeeToUpdate.getEmpname(),
				employeeToUpdate.getOccupation(), employeeToUpdate.getGender(), employeeToUpdate.getDepartment(),
				localDate, employeeToUpdate.getEmpid());

		cassandraOps.execute(statement);

	}
}