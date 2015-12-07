package com.inb.rest.entity;

import java.util.Date;

public abstract class EmployeePOJO extends PersonPOJO {
	
	private String username;
	private String password;
	
	
	
	public EmployeePOJO() {
		super();
	}
	
	
	public EmployeePOJO(String firstName, String lastName, String email,
			long phone, String address, Date dateOfBirth, String username,
			String password) {
		super(firstName, lastName, email, phone, address, dateOfBirth);
		this.username = username;
		this.password = password;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password
				+ "]";
	}
	
	
}
