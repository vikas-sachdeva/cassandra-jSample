package cassandra.jsample.operations;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import cassandra.jsample.constants.Queries;
import cassandra.jsample.model.Employee;

public class SelectOperation {

	public List<Employee> perform(Session session) {

		CassandraOperations cassandraOps = new CassandraTemplate(session);

		ResultSet resultSet = cassandraOps.query(Queries.SELECT);

		List<Row> list = resultSet.all();
		List<Employee> employeeList = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for (Row row : list) {

			LocalDate date = row.getDate("dateofbirth");
			calendar.set(date.getYear(), date.getMonth(), date.getDay());

			Employee employee = new Employee(row.getUUID("empid"), row.getString("empname"),
					row.getString("occupation"), row.getString("gender"), row.getString("department"),
					calendar.getTime());
			employeeList.add(employee);
		}
		return employeeList;

	}
}
