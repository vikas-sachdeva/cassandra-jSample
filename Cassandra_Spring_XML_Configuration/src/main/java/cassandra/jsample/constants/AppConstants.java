package cassandra.jsample.constants;

public class AppConstants {

	public static final String NAMESPACE_NAME = "emp";

	public static final String COLUMN_FAMILY_NAME = "employee";
	
	public static final String SELECT = "SELECT empid, empname, occupation, gender, department, dateofbirth FROM emp.employee;";

}
