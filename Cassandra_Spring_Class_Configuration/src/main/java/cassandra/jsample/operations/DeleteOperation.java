package cassandra.jsample.operations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

import cassandra.jsample.model.Employee;

@Component
public class DeleteOperation {

	@Autowired
	private CassandraOperations cassandraOperations;

	public void perform(UUID employeeIdToBeDeleted) {
		cassandraOperations.deleteById(Employee.class, employeeIdToBeDeleted);

	}
}