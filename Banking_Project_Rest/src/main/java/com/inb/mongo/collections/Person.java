package com.inb.mongo.collections;

import java.util.Date;

import org.springframework.data.annotation.Id;



abstract public class Person {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private long phone;
	private String address;
	private Date dateOfBirth;
	private Branch branch;
	private boolean isLogin;
	
	public boolean isLogin() {
		return isLogin;
	}



	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}



	public Person() {
		super();
	}



	public Person(String firstName, String lastName, String email, long phone,
			String address, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}

	

	public String getId() {
		return id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public long getPhone() {
		return phone;
	}



	public void setPhone(long phone) {
		this.phone = phone;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Date getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public Branch getBranch() {
		return branch;
	}



	public void setBranch(Branch branch) {
		this.branch = branch;
	}



	public void setId(String id) {
		this.id = id;
	}

	
	

}
