package com.inb.rest.entity;

import java.util.Date;

abstract public class PersonPOJO {

	private String firstName;
	private String lastName;
	private String email;
	private long phone;
	private String address;
	private Date dateOfBirth;
	private BranchPOJO branchPOJO;
	private boolean isLogin;
	
	public boolean isLogin() {
		return isLogin;
	}



	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}



	public BranchPOJO getBranchPOJO() {
		return branchPOJO;
	}



	public void setBranchPOJO(BranchPOJO branchPOJO) {
		this.branchPOJO = branchPOJO;
	}



	public PersonPOJO() {
		super();
	}



	public PersonPOJO(String firstName, String lastName, String email, long phone,
			String address, Date dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}

	public PersonPOJO(String firstName, String lastName, String email, long phone, String address,
			Date dateOfBirth, BranchPOJO branchPOJO) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.branchPOJO = branchPOJO;
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



	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", dateOfBirth=" + dateOfBirth + "]";
	}
	
	

}
