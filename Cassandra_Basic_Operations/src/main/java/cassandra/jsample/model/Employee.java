package cassandra.jsample.model;

import java.util.Date;

public class Employee {

	private String empid;

	private String empname;

	private String occupation;

	private String gender;

	private String department;

	private Date dateofbirth;

	public Employee(String empid, String empname, String occupation, String gender, String department, Date dateofbirth) {
		this.empid = empid;
		this.empname = empname;
		this.occupation = occupation;
		this.gender = gender;
		this.department = department;
		this.dateofbirth = dateofbirth;
	}

	public Employee(String empname, String occupation, String gender, String department, Date dateofbirth) {
		this.empname = empname;
		this.occupation = occupation;
		this.gender = gender;
		this.department = department;
		this.dateofbirth = dateofbirth;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpId(String id) {
		this.empid = id;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	@Override
	public String toString() {
		return "Employee [id=" + empid + ", empname=" + empname + ", occupation=" + occupation + ", gender=" + gender
				+ ", department=" + department + ", dateofbirth=" + dateofbirth + "]";
	}

}
