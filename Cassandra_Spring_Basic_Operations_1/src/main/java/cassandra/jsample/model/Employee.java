package cassandra.jsample.model;

import java.util.UUID;

import com.datastax.driver.core.LocalDate;

public class Employee {

	private UUID empid;

	private String empname;

	private String occupation;

	private String gender;

	private String department;

	private LocalDate dateofbirth;

	public Employee(UUID empid, String empname, String occupation, String gender, String department,
			LocalDate dateofbirth) {
		this.empid = empid;
		this.empname = empname;
		this.occupation = occupation;
		this.gender = gender;
		this.department = department;
		this.dateofbirth = dateofbirth;
	}

	public Employee(String empname, String occupation, String gender, String department, LocalDate dateofbirth) {
		this(null, empname, occupation, gender, department, dateofbirth);
	}

	public UUID getEmpid() {
		return empid;
	}

	public void setEmpId(UUID id) {
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

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", occupation=" + occupation + ", gender=" + gender
				+ ", department=" + department + ", dateofbirth=" + dateofbirth + "]";
	}

}
