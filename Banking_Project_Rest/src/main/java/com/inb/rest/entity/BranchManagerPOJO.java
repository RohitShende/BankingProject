package com.inb.rest.entity;

import java.util.Date;

public class BranchManagerPOJO extends EmployeePOJO{

	
	public BranchManagerPOJO() {
		super();
	}

	public BranchManagerPOJO(String firstName, String lastName, String email,
			long phone, String address, Date dateOfBirth, String userName,
			String password) {
		super(firstName, lastName, email, phone, address, dateOfBirth,
				userName, password);
	
	}

	public BranchManagerPOJO(String firstName, String lastName, String email,
			long phone, String address,Date dateOfBirth, String userName,
			String password,BranchPOJO branchPOJO) {
		super(firstName, lastName, email, phone, address, dateOfBirth,
				userName, password,branchPOJO);
	
	}
	
	@Override
	public String toString() {
		return "BranchManagerPOJO ["+super.toString()+"]";
	}

	

	
	
	
}
