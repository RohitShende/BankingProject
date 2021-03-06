package com.inb.mongo.collections;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="branch_manager")
public class BranchManager extends Employee{

	public BranchManager() {
		super();
	}

	public BranchManager(String firstName, String lastName, String email,
			long phone, String address, Date dateOfBirth, String userName,
			String password ) {
		super(firstName, lastName, email, phone, address, dateOfBirth,
				userName, password);
	
	}

	public BranchManager(String firstName, String lastName, String email,
			long phone, String address,Date dateOfBirth, String userName,
			String password,Branch branch) {
		super(firstName, lastName, email, phone, address, dateOfBirth,
				userName, password,branch);
	
	}
	
}
