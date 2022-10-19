package com.APItest.models;

public class AdduserPOJO {

	private String accountno;
	private int departmentno;
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	public int getDepartmentno() {
		return departmentno;
	}
	public void setDepartmentno(int departmentno) {
		this.departmentno = departmentno;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	private int salary;
	private int pincode;
}
