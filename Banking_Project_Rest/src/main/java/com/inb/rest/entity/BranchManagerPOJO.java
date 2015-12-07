package com.inb.rest.entity;

import java.util.Date;

public class BranchManagerPOJO extends EmployeePOJO{

	private BranchPOJO branch;
	
	public BranchManagerPOJO() {
		super();
	}

	public BranchManagerPOJO(String firstName, String lastName, String email,
			long phone, String address, Date dateOfBirth, String username,
			String password, BranchPOJO branch) {
		super(firstName, lastName, email, phone, address, dateOfBirth,
				username, password);
		this.branch = branch;
	}

	public BranchPOJO getBranch() {
		return branch;
	}

	public void setBranch(BranchPOJO branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "BranchManager [branch=" + branch + "]";
	}
	
	
	
}
