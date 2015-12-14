package com.inb.mongo.collections;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.inb.rest.entity.Account;

@Document(collection = "unregistered_customer")
public class UnregisteredCustomer extends Customer {
	long enqId;

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
