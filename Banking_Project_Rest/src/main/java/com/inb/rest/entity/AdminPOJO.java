package com.inb.rest.entity;

import java.util.Date;

public class AdminPOJO extends EmployeePOJO {

	public AdminPOJO() {
		super();
	}

	public AdminPOJO(String firstName, String lastName, String email, long phone,
			String address, Date dateOfBirth, String username, String password) {
		super(firstName, lastName, email, phone, address, dateOfBirth, username,
				password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin []";
	}

	
		
}
