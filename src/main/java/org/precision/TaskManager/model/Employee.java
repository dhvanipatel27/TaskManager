package org.precision.TaskManager.model;

public class Employee {

	private int empId;
	private String EmpName;
	
	public Employee(int empId, String empName) {
		super();
		this.empId = empId;
		EmpName = empName;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	
	
}
