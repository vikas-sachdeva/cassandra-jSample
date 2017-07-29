package cassandra.jsample.operations;

import java.util.UUID;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

import cassandra.jsample.constants.AppConstants;
import cassandra.jsample.model.Employee;

public class DeleteOperation {

	public void perform(Cluster cluster, UUID employeeIdToBeDeleted) {

		Session session = cluster.connect(AppConstants.NAMESPACE_NAME);

		CassandraOperations cassandraOps = new CassandraTemplate(session);

		cassandraOps.deleteById(Employee.class, employeeIdToBeDeleted);

	}
}
