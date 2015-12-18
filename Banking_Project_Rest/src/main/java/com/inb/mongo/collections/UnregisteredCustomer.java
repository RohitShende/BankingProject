package com.inb.mongo.collections;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.inb.rest.entity.Account;

@Document(collection = "unregistered_customer")
public class UnregisteredCustomer extends Customer {
	long enqId;
	String applicationStatus;
	Account account;

	public UnregisteredCustomer() {
		super();
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public UnregisteredCustomer(String firstName, String lastName,
			String email, long phone, String address, Date dateOfBirth,
			long enqId, Account account) {
		super(firstName, lastName, email, phone, address, dateOfBirth);
		this.enqId = enqId;
		this.account = account;
	}

	public UnregisteredCustomer(String firstName, String lastName,
			String email, long phone, String address, Date dateOfBirth,
			long enqId, Account account,String applicationStatus) {
		super(firstName, lastName, email, phone, address, dateOfBirth);
		this.enqId = enqId;
		this.account = account;
		this.applicationStatus=applicationStatus;
	}
	
	public UnregisteredCustomer(String firstName, String lastName,
			String email, long phone, String address, Date dateOfBirth,
			long enqId, Account account,String applicationStatus,Branch branch) {
		super(firstName, lastName, email, phone, address, dateOfBirth, branch);
		this.enqId = enqId;
		this.account = account;
		this.applicationStatus=applicationStatus;
	}
	
	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public long getEnqId() {
		return enqId;
	}

	public void setEnqId(long enqId) {
		this.enqId = enqId;
	}

	@Override
	public String toString() {
		return "UnregisteredCustomer [enqId=" + enqId + "]" + "["
				+ super.toString() + "]";
	}

}
