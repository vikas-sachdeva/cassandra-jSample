package cassandra.jsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.datastax.driver.core.LocalDate;

import cassandra.jsample.controller.EmployeeController;
import cassandra.jsample.model.Employee;

/**
 * Run this program by passing below command-line arguments -
 * 
 * --spring.config.location=file:./config/cassandra.properties
 *
 */

@SpringBootApplication
public class CassandraSpringBootBasicOperationsApplication {

	public static void main(String[] args) {

		try (ConfigurableApplicationContext context = new SpringApplicationBuilder()
				.sources(CassandraSpringBootBasicOperationsApplication.class).bannerMode(Mode.OFF).run(args)) {

			CassandraSpringBootBasicOperationsApplication app = (CassandraSpringBootBasicOperationsApplication) context
					.getBean("cassandraSpringBootBasicOperationsApplication");

			app.callController();
		}

	}

	@Autowired
	private EmployeeController controller;

	private void callController() {

		controller.createColumnFamily();

		controller.printData();

		Employee employee = new Employee("George", "Professor", "Male", "MBA",
				LocalDate.fromYearMonthDay(1950, 01, 21));
		controller.insert(employee);

		controller.printData();

		employee = new Employee("Bob", "Assistant Professor", "Male", "MBA", LocalDate.fromYearMonthDay(1985, 02, 15));
		controller.insert(employee);

		controller.printData();

		controller.update("Bob", "Alice");

		controller.printData();

		controller.deleteEmployeeHavingName("Alice");

		controller.printData();

		controller.dropColumnFamily();
	}
}
