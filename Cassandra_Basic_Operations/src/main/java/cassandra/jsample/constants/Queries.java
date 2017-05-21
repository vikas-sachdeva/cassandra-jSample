package cassandra.jsample.constants;

public class Queries {

	public static final String CREATE_KEYSPACE = "CREATE KEYSPACE emp WITH REPLICATION = {'class':'SimpleStrategy','replication_factor' : 1};";

	public static final String CREATE_COLUMN_FAMILY = "CREATE TABLE emp.Employee(empid UUID, empname VARCHAR, occupation VARCHAR, gender VARCHAR, department VARCHAR, dateofbirth DATE, PRIMARY KEY (empid));";

	public static final String INSERT = "INSERT INTO emp.Employee(empid, empname, occupation, gender, department, dateofbirth ) VALUES ( uuid(), ?, ?, ?, ?, ?);";

	public static final String SELECT = "SELECT * FROM emp.Employee;";

	public static final String UPDATE = "UPDATE emp.Employee SET empname = ?, occupation = ? , gender = ?, department = ?, dateOfbirth = ? WHERE empid = ?;";

	public static final String DELETE = "DELETE FROM emp.Employee WHERE empid = ?;";
	
	public static final String DROP_COLUMN_FAMILY = "DROP TABLE emp.Employee";
	
	public static final String DROP_KEYSPACE = "DROP KEYSPACE emp";

}
