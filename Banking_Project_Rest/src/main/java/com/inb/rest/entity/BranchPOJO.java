package com.inb.rest.entity;

public class BranchPOJO {
	
	private String ifscCode;
	private String branchName;
	private String address;
	private long contact;
	private BranchManagerPOJO branchManager;
	
	public BranchPOJO() {
		super();
	}
	
	public BranchPOJO(String ifscCode, String branchName, String address,
			long contact) {
		super();
		this.ifscCode = ifscCode;
		this.branchName = branchName;
		this.address = address;
		this.contact = contact;
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
	public BranchManagerPOJO getBranchManager() {
		return branchManager;
	}
	public void setBranchManager(BranchManagerPOJO branchManager) {
		this.branchManager = branchManager;
	}

	@Override
	public String toString() {
		return "Branch [ifscCode=" + ifscCode + ", branchName=" + branchName
				+ ", address=" + address + ", contact=" + contact
				+ ", branchManager=" + branchManager + "]";
	}
	
	
	

}
