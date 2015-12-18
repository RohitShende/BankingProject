package com.inb.rest.entity;

import java.util.Date;

public class AdminPOJO extends EmployeePOJO {

	public AdminPOJO() 
	{
		super();
	}

	public AdminPOJO(String firstName, String lastName, String email, long phone,
			String address, Date dateOfBirth, String userName, String password) 
	{
		super(firstName, lastName, email, phone, address, dateOfBirth, userName,
				password);
	}

	@Override
	public String toString() 
	{
		return "Admin ["+super.toString()+"]";
	}

	
		
}
