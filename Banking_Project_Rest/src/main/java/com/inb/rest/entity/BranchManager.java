package com.inb.rest.entity;

import java.util.Date;

public class BranchManager extends Employee{

	private Branch branch;
	
	public BranchManager() {
		super();
	}

	public BranchManager(String firstName, String lastName, String email,
			long phone, String address, Date dateOfBirth, String username,
			String password, Branch branch) {
		super(firstName, lastName, email, phone, address, dateOfBirth,
				username, password);
		this.branch = branch;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "BranchManager [branch=" + branch + "]";
	}
	
	
	
}
