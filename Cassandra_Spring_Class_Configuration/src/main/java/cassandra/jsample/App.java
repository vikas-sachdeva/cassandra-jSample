package cassandra.jsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.LocalDate;

import cassandra.jsample.configuration.SpringConfig;
import cassandra.jsample.controller.EmployeeController;
import cassandra.jsample.model.Employee;

@Component
public class App {
	public static void main(String[] args) {

		try (AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringConfig.class);) {

			App app = (App) applicationContext.getBean("app");

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
