package com.inb.rest.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class UnregisteredCustomerPOJO extends CustomerPOJO {
	
	@Id
	String id;
	long enqId;
	Account account;

	public UnregisteredCustomerPOJO() {
		super();
	}

	public UnregisteredCustomerPOJO(String firstName, String lastName,
			String email, long phone, String address, Date dateOfBirth,
			long enqId, Account account) {
		super(firstName, lastName, email, phone, address, dateOfBirth);
		this.enqId = enqId;
		this.account = account;
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getEnqId() {
		return enqId;
	}

	public void setEnqId(long enqId) {
		this.enqId = enqId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "UnregisteredCustomer [enqId=" + enqId + "]" + "["
				+ super.toString() + "]";
	}

}
