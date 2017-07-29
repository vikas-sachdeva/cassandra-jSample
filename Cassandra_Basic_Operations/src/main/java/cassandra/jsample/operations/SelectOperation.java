package cassandra.jsample.operations;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import cassandra.jsample.constants.Queries;
import cassandra.jsample.model.Employee;

public class SelectOperation {

	public List<Employee> perform(Session session) {
		ResultSet resultSet = session.execute(Queries.SELECT);
		List<Row> list = resultSet.all();
		List<Employee> employeeList = new ArrayList<>();
		for (Row row : list) {
			Employee employee = new Employee(row.getUUID("empid").toString(), row.getString("empname"),
					row.getString("occupation"), row.getString("gender"), row.getString("department"),
					row.getDate("dateofbirth"));
			employeeList.add(employee);
		}
		return employeeList;
	}
}
