package cassandra.jsample.operations;

import java.util.List;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

import cassandra.jsample.constants.AppConstants;
import cassandra.jsample.model.Employee;

public class SelectOperation {

	public List<Employee> perform(Cluster cluster) {

		Session session = cluster.connect(AppConstants.NAMESPACE_NAME);

		CassandraOperations cassandraOps = new CassandraTemplate(session);

		return cassandraOps.select(AppConstants.SELECT, Employee.class);

	}
}
