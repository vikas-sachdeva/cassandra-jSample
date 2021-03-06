package cassandra.jsample.constants;

public class Queries {

	public static final String CREATE_KEYSPACE = "CREATE KEYSPACE emp WITH REPLICATION = {'class':'SimpleStrategy','replication_factor' : 1};";

	public static final String CREATE_COLUMN_FAMILY = "CREATE TABLE emp.employee(empid uuid, empname varchar, occupation varchar, gender varchar, department varchar, dateofbirth date, PRIMARY KEY (empid));";

	public static final String INSERT = "INSERT INTO emp.employee(empid, empname, occupation, gender, department, dateofbirth ) VALUES ( uuid(), ?, ?, ?, ?, ?);";

	public static final String SELECT = "SELECT empid, empname, occupation, gender, department, dateofbirth FROM emp.employee;";

	public static final String UPDATE = "UPDATE emp.employee SET empname = ?, occupation = ? , gender = ?, department = ?, dateOfbirth = ? WHERE empid = ?;";

	public static final String DELETE = "DELETE FROM emp.employee WHERE empid = ?;";

	public static final String DROP_COLUMN_FAMILY = "DROP TABLE emp.employee";

	public static final String DROP_KEYSPACE = "DROP KEYSPACE emp";

}
