package cassandra.jsample.operations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

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
		for (Row row : list) {
			Employee employee = new Employee(row.getUUID("empid"), row.getString("empname"),
					row.getString("occupation"), row.getString("gender"), row.getString("department"),
					row.getDate("dateofbirth"));
			employeeList.add(employee);
		}
		return employeeList;

	}
}
