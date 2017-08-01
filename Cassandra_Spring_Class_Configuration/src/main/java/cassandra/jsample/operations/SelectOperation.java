package cassandra.jsample.operations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

import cassandra.jsample.constants.AppConstants;
import cassandra.jsample.model.Employee;

@Component
public class SelectOperation {

	@Autowired
	private CassandraOperations cassandraOperations;

	public List<Employee> perform() {

		return cassandraOperations.select(AppConstants.SELECT, Employee.class);

	}
}
