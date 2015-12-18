package com.inb.mongo.collections;

import java.util.Date;


public abstract class Customer extends Person {

	public Customer(String firstName, String lastName, String email,
			long phone, String address, Date dateOfBirth) {
		super(firstName, lastName, email, phone, address, dateOfBirth);
	}

	public Customer() {
		super();
	}

}
