package cassandra.jsample.controller;

import java.util.List;

import com.datastax.driver.core.Cluster;

import cassandra.jsample.model.Employee;
import cassandra.jsample.operations.CreateColumnFamilyOperation;
import cassandra.jsample.operations.CreateKeyspaceOperation;
import cassandra.jsample.operations.DeleteOperation;
import cassandra.jsample.operations.DropColumnFamilyOperation;
import cassandra.jsample.operations.DropKeyspaceOperation;
import cassandra.jsample.operations.InsertOperation;
import cassandra.jsample.operations.SelectOperation;
import cassandra.jsample.operations.UpdateOperation;
import cassandra.jsample.util.ConnectionSessionFactory;

public class EmployeeController {

	private String serverHostName;

	private int portNo;

	public EmployeeController(String serverHostName, int portNo) {
		this.serverHostName = serverHostName;
		this.portNo = portNo;
	}

	public void createKeyspace() {
		ConnectionSessionFactory connectionSessionFactory = new ConnectionSessionFactory();
		connectionSessionFactory.connect(serverHostName, portNo);
		Cluster cluster = connectionSessionFactory.getCluster();
		try {
			new CreateKeyspaceOperation().perform(cluster);
		} finally {
			connectionSessionFactory.close();
		}
		System.out.println("\nKeyspace created");
	}

	public void createColumnFamily() {
		ConnectionSessionFactory connectionSessionFactory = new ConnectionSessionFactory();
		connectionSessionFactory.connect(serverHostName, portNo);
		Cluster cluster = connectionSessionFactory.getCluster();
		try {
			new CreateColumnFamilyOperation().perform(cluster);
		} finally {
			connectionSessionFactory.close();
		}
		System.out.println("\nColumnFamily created");
	}

	public void insert(Employee employee) {
		ConnectionSessionFactory connectionSessionFactory = new ConnectionSessionFactory();
		connectionSessionFactory.connect(serverHostName, portNo);
		Cluster cluster = connectionSessionFactory.getCluster();
		try {
			InsertOperation insertOperation = new InsertOperation();
			insertOperation.perform(cluster, employee);
		} finally {
			connectionSessionFactory.close();
		}
		System.out.println("\nEmployee inserted -\n" + employee);
	}

	public void update(String oldEmpname, String newEmpname) {
		ConnectionSessionFactory connectionSessionFactory = new ConnectionSessionFactory();
		connectionSessionFactory.connect(serverHostName, portNo);
		Cluster cluster = connectionSessionFactory.getCluster();
		try {
			SelectOperation selectOperation = new SelectOperation();
			List<Employee> employeeList = selectOperation.perform(cluster);
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
				UpdateOperation updateOperation = new UpdateOperation();
				updateOperation.perform(cluster, employeeToBeUpdated);
				System.out.println("\nEmployee name updated -\n" + employeeToBeUpdated);
			}
		} finally {
			connectionSessionFactory.close();
		}
	}

	public void printData() {
		ConnectionSessionFactory connectionSessionFactory = new ConnectionSessionFactory();
		connectionSessionFactory.connect(serverHostName, portNo);
		Cluster cluster = connectionSessionFactory.getCluster();

		SelectOperation selectOperation = new SelectOperation();
		try {
			List<Employee> employeeList = selectOperation.perform(cluster);
			if (employeeList.isEmpty()) {
				System.out.println("\nNo employee data found");
			} else {
				System.out.println("\nCurrent employee list - ");
				for (Employee employee : employeeList) {
					System.out.println(employee);
				}
			}
		} finally {
			connectionSessionFactory.close();
		}
	}

	public void deleteEmployeeHavingName(String empname) {
		ConnectionSessionFactory connectionSessionFactory = new ConnectionSessionFactory();
		connectionSessionFactory.connect(serverHostName, portNo);
		Cluster cluster = connectionSessionFactory.getCluster();
		try {
			SelectOperation selectOperation = new SelectOperation();
			List<Employee> employeeList = selectOperation.perform(cluster);
			Employee employeeToBeDeleted = null;
			for (Employee employee : employeeList) {
				if (employee.getEmpname().equals(empname)) {
					employeeToBeDeleted = employee;
					break;
				}
			}
			if (employeeToBeDeleted != null) {
				DeleteOperation deleteOperation = new DeleteOperation();
				deleteOperation.perform(cluster, employeeToBeDeleted.getEmpid());
				System.out.println("\nEmployee Deleted -\n" + employeeToBeDeleted);
			} else {
				System.out.println("\nEmployee having name " + empname + " is not found");
			}
		} finally {
			connectionSessionFactory.close();
		}
	}

	public void dropKeyspace() {
		ConnectionSessionFactory connectionSessionFactory = new ConnectionSessionFactory();
		connectionSessionFactory.connect(serverHostName, portNo);
		Cluster cluster = connectionSessionFactory.getCluster();
		try {
			new DropKeyspaceOperation().perform(cluster);
		} finally {
			connectionSessionFactory.close();
		}
		System.out.println("\nKeyspace dropped");
	}

	public void dropColumnFamily() {
		ConnectionSessionFactory connectionSessionFactory = new ConnectionSessionFactory();
		connectionSessionFactory.connect(serverHostName, portNo);
		Cluster cluster = connectionSessionFactory.getCluster();
		try {
			new DropColumnFamilyOperation().perform(cluster);
		} finally {
			connectionSessionFactory.close();
		}
		System.out.println("\nColumn family dropped");
	}
}