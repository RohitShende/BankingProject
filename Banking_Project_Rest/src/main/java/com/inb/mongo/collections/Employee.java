package com.inb.mongo.collections;

import java.util.Date;

public abstract class Employee extends Person {
	
	private String userName;
	private String password;
	
	
	
	public Employee() {
		super();
	}
	
	
	public Employee(String firstName, String lastName, String email,
			long phone, String address, Date dateOfBirth, String userName,
			String password) {
		super(firstName, lastName, email, phone, address, dateOfBirth);
		this.userName = userName;
		this.password = password;
	}

	public Employee(String firstName, String lastName, String email,
			long phone, String address, Date dateOfBirth, String userName,
			String password, Branch branch) {
		super(firstName, lastName, email, phone, address, dateOfBirth, branch);
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



	
	
}
