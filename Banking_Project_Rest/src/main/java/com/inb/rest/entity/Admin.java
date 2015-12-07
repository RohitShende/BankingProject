package com.inb.rest.entity;

import java.util.Date;

public class Admin extends Employee {

	public Admin() {
		super();
	}

	public Admin(String firstName, String lastName, String email, long phone,
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
