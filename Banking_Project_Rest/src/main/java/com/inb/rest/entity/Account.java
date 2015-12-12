package com.inb.rest.entity;

public class Account implements Comparable<Account> {

	AccountType accountType;
	long accountNumber;
	double balance;
	float interestRate;

	public Account() {
		super();
	}

	public Account(long accountNumber, double balance, float interestRate,
			AccountType accountType) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountType = accountType;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public int compareTo(Account o) {
		if (this.accountNumber == o.accountNumber) {
			return 0;

		}
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		Account account = (Account) obj;
		if (this.accountNumber == account.accountNumber) {
			return true;

		}
		return false;
	}

}
