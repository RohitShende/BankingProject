package com.inb.mongo.collections;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="admin")
public class Admin extends Employee {

	public Admin() {
		super();
	}

	public Admin(String firstName, String lastName, String email, long phone,
			String address, Date dateOfBirth, String userName, String password) {
		super(firstName, lastName, email, phone, address, dateOfBirth, userName,
				password);
	}

	
	
		
}
