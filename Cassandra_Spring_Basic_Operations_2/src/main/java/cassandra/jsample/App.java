package cassandra.jsample;

import com.datastax.driver.core.LocalDate;

import cassandra.jsample.controller.EmployeeController;
import cassandra.jsample.model.Employee;

public class App {
	public static void main(String[] args) {

		EmployeeController controller = new EmployeeController("192.168.56.101", 9042);

		controller.createKeyspace();

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

		controller.dropKeyspace();

	}
}