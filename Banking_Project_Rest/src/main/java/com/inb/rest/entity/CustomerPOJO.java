package com.inb.rest.entity;

import java.util.Date;

public abstract class CustomerPOJO extends PersonPOJO {

	public CustomerPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerPOJO(String firstName, String lastName, String email,
			long phone, String address, Date dateOfBirth) {
		super(firstName, lastName, email, phone, address, dateOfBirth);
		// TODO Auto-generated constructor stub
	}

}
