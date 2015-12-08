package com.inb.mongo.collections;

import java.util.Date;

public abstract class Employee extends Person {
	
	private String username;
	private String password;
	
	
	
	public Employee() {
		super();
	}
	
	
	public Employee(String firstName, String lastName, String email,
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



	
	
}
