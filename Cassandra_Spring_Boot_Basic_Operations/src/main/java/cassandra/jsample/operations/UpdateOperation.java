package cassandra.jsample.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

import cassandra.jsample.model.Employee;

@Component
public class UpdateOperation {

	@Autowired
	private CassandraOperations cassandraOperations;

	public void perform(Employee employeeToUpdate) {

		cassandraOperations.update(employeeToUpdate);

	}
}