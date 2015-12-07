package com.inb.mongo.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="branch")
public class Branch {
	
	@Id
	private String ifscCode;
	private String branchName;
	private String address;
	private long contact;
	private BranchManager branchManager;
	
	
	
	public Branch() {
		super();
	}
	
	
	public Branch(String ifscCode, String branchName, String address, long contact, BranchManager branchManager) {
		super();
		this.ifscCode = ifscCode;
		this.branchName = branchName;
		this.address = address;
		this.contact = contact;
		this.branchManager = branchManager;
	}


	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public BranchManager getBranchManager() {
		return branchManager;
	}
	public void setBranchManager(BranchManager branchManager) {
		this.branchManager = branchManager;
	}

	@Override
	public String toString() {
		return "Branch [ifscCode=" + ifscCode + ", branchName=" + branchName
				+ ", address=" + address + ", contact=" + contact
				+ ", branchManager=" + branchManager + "]";
	}
	
	
	

}
