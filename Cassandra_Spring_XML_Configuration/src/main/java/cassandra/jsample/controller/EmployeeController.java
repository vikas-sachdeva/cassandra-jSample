package cassandra.jsample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cassandra.jsample.model.Employee;
import cassandra.jsample.operations.CreateColumnFamilyOperation;
import cassandra.jsample.operations.DeleteOperation;
import cassandra.jsample.operations.DropColumnFamilyOperation;
import cassandra.jsample.operations.InsertOperation;
import cassandra.jsample.operations.SelectOperation;
import cassandra.jsample.operations.UpdateOperation;

@Component
public class EmployeeController {

	@Autowired
	private InsertOperation insertOperation;

	@Autowired
	private UpdateOperation updateOperation;

	@Autowired
	private SelectOperation selectOperation;

	@Autowired
	private DeleteOperation deleteOperation;

	@Autowired
	private CreateColumnFamilyOperation createColumnFamilyOperation;

	@Autowired
	private DropColumnFamilyOperation dropColumnFamilyOperation;

	public void createColumnFamily() {

		createColumnFamilyOperation.perform();

		System.out.println("\nColumnFamily created");
	}

	public void insert(Employee employee) {
		insertOperation.perform(employee);
		System.out.println("\nEmployee inserted -\n" + employee);
	}

	public void update(String oldEmpname, String newEmpname) {

		List<Employee> employeeList = selectOperation.perform();
		Employee employeeToBeUpdated = null;
		for (Employee employee : employeeList) {
			if (employee.getEmpname().equals(oldEmpname)) {
				employeeToBeUpdated = employee;
				break;
			}
		}
		if (employeeToBeUpdated == null) {
			System.out.println("\nEmployee having name " + oldEmpname + " is not found");
		} else {

			employeeToBeUpdated.setEmpname(newEmpname);
			updateOperation.perform(employeeToBeUpdated);
			System.out.println("\nEmployee name updated -\n" + employeeToBeUpdated);
		}

	}

	public void printData() {

		List<Employee> employeeList = selectOperation.perform();
		if (employeeList.isEmpty()) {
			System.out.println("\nNo employee data found");
		} else {
			System.out.println("\nCurrent employee list - ");
			for (Employee employee : employeeList) {
				System.out.println(employee);
			}
		}

	}

	public void deleteEmployeeHavingName(String empname) {
		List<Employee> employeeList = selectOperation.perform();
		Employee employeeToBeDeleted = null;
		for (Employee employee : employeeList) {
			if (employee.getEmpname().equals(empname)) {
				employeeToBeDeleted = employee;
				break;
			}
		}
		if (employeeToBeDeleted != null) {
			deleteOperation.perform(employeeToBeDeleted.getEmpid());
			System.out.println("\nEmployee Deleted -\n" + employeeToBeDeleted);
		} else {
			System.out.println("\nEmployee having name " + empname + " is not found");
		}

	}

	public void dropColumnFamily() {

		dropColumnFamilyOperation.perform();

		System.out.println("\nColumn family dropped");
	}

}