package com.inb.rest.entity;

import java.util.Date;

public class BranchManagerPOJO extends EmployeePOJO{

	
	public BranchManagerPOJO() {
		super();
	}

	public BranchManagerPOJO(String firstName, String lastName, String email,
			long phone, String address, Date dateOfBirth, String username,
			String password) {
		super(firstName, lastName, email, phone, address, dateOfBirth,
				username, password);
	
	}

	@Override
	public String toString() {
		return "BranchManagerPOJO ["+super.toString()+"]";
	}

	

	
	
	
}
