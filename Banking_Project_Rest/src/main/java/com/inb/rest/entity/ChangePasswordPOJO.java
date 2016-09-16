package com.inb.rest.entity;

public class ChangePasswordPOJO {
	
	long customerId;
	String newPassword;
	
	public ChangePasswordPOJO() {
	}
	public ChangePasswordPOJO(int customerId, String newPassword) {
		this.customerId = customerId;
		this.newPassword = newPassword;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
}
