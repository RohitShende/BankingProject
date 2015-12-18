package com.inb.mongo.collections;

import java.util.Date;
import java.util.HashSet;

import org.springframework.data.mongodb.core.mapping.Document;

import com.inb.rest.entity.Account;


@Document(collection="registered_customer")
public class RegisteredCustomer extends Customer
{

	long customerId;
	String userName;
	String password;
	String authorizedImageName;
	String authorizedImageText;
	HashSet<Account> accounthash;
	String applicationStatus;
	
	public RegisteredCustomer() {
		super();
	}
	public RegisteredCustomer(String firstName, String lastName, String email,
			long phone, String address, Date dateOfBirth, long customerId, String userName, String password,
			String authorizedImageName, String authorizedImageText) {
		super(firstName, lastName, email, phone, address, dateOfBirth);
		this.customerId = customerId;
		this.userName = userName;
		this.password = password;
		this.authorizedImageName = authorizedImageName;
		this.authorizedImageText = authorizedImageText;
	}
	public RegisteredCustomer(String firstName, String lastName, String email,
			long phone, String address, Date dateOfBirth,long customerId,String password,HashSet<Account> accounthash) {
		super(firstName, lastName, email, phone, address, dateOfBirth);
		this.customerId=customerId;
		this.password = password;
		this.accounthash=accounthash;
	}
	
	public RegisteredCustomer(String firstName, String lastName, String email,
			long phone, String address, Date dateOfBirth,long customerId,String password,HashSet<Account> accounthash, Branch branch) {
		super(firstName, lastName, email, phone, address, dateOfBirth, branch);
		this.customerId=customerId;
		this.password = password;
		this.accounthash=accounthash;
	}
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAuthorizedImageName() {
		return authorizedImageName;
	}
	public void setAuthorizedImageName(String authorizedImageName) {
		this.authorizedImageName = authorizedImageName;
	}
	public String getAuthorizedImageText() {
		return authorizedImageText;
	}
	public void setAuthorizedImageText(String authorizedImageText) {
		this.authorizedImageText = authorizedImageText;
	}
	public HashSet<Account> getAccounthash() {
		return accounthash;
	}
	public void setAccounthash(HashSet<Account> accounthash) {
		this.accounthash = accounthash;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	@Override
	public String toString() {
		return "RegisteredCustomer [customerId=" + customerId + ", userName="
				+ userName + ", password=" + password
				+ ", authorizedImageName=" + authorizedImageName
				+ ", authorizedImageText=" + authorizedImageText +"["+accounthash+"]"+ "]"+"["+super.toString()+"]";
	}

	
}
