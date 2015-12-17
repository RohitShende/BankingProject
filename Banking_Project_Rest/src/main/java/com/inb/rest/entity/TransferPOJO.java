package com.inb.rest.entity;

public class TransferPOJO {
	@Override
	public String toString() {
		return "TransferPOJO [clientAccount=" + clientAccount
				+ ", recevierAccount=" + recevierAccount + ", amount=" + amount
				+ "]";
	}


	long clientAccount;
	long recevierAccount;
	Float amount;
	
	
	public TransferPOJO() {
		super();
	}


	public TransferPOJO(long clientAccount, long recevierAccount, Float amount) {
		super();
		this.clientAccount = clientAccount;
		this.recevierAccount = recevierAccount;
		this.amount = amount;
	}


	public long getClientAccount() {
		return clientAccount;
	}


	public void setClientAccount(long clientAccount) {
		this.clientAccount = clientAccount;
	}


	public long getRecevierAccount() {
		return recevierAccount;
	}


	public void setRecevierAccount(long recevierAccount) {
		this.recevierAccount = recevierAccount;
	}


	public Float getAmount() {
		return amount;
	}


	public void setAmount(Float amount) {
		this.amount = amount;
	}


}
