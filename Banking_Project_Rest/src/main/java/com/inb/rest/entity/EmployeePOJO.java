package com.inb.rest.entity;

import java.util.Date;

public abstract class EmployeePOJO extends PersonPOJO {
	
	private String userName;
	private String password;
	
	
	
	public EmployeePOJO() {
		super();
	}
	
	
	public EmployeePOJO(String firstName, String lastName, String email,
			long phone, String address, Date dateOfBirth, String userName,
			String password) {
		super(firstName, lastName, email, phone, address, dateOfBirth);
		this.userName = userName;
		this.password = password;
	}
	
	public EmployeePOJO(String firstName, String lastName, String email,
			long phone, String address, Date dateOfBirth, String userName,
			String password, BranchPOJO branchPOJO) {
		super(firstName, lastName, email, phone, address, dateOfBirth, branchPOJO);
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", password=" + password
				+ "]["+super.toString()+"]";
	}
	
	
}
