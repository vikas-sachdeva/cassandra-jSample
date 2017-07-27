package cassandra.jsample;

import java.util.Calendar;

import cassandra.jsample.controller.EmployeeController;
import cassandra.jsample.model.Employee;

public class App {
	public static void main(String[] args) {

		EmployeeController controller = new EmployeeController("192.168.56.101", 9042);

		controller.createKeyspace();

		controller.createColumnFamily();

		controller.printData();

		Calendar calendar = Calendar.getInstance();
		calendar.set(1960, 01, 21);
		Employee employee = new Employee("George", "Professor", "Male", "MBA", calendar.getTime());
		controller.insert(employee);

		controller.printData();

		calendar.set(1985, 02, 15);
		employee = new Employee("Bob", "Assistant Professor", "Male", "MBA", calendar.getTime());
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