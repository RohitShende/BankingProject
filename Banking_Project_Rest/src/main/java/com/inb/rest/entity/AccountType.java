package com.inb.rest.entity;

public enum AccountType {

	SAVINGACCOUNT(1), CURRENTACCOUNT(2);
	int val;

	private AccountType(int val) {
		this.val = val;
	}

	public int getValue() {
		return val;
	}

	public String toString() {
		return val + " " + super.toString();
	}
}
