package com.inb.mongo.collections;

import java.io.File;
import java.util.Date;

public abstract class Customer extends Person {

	private File addressProof;
	private File ageProof;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String firstName, String lastName, String email,
			long phone, String address, Date dateOfBirth, File addressProof,
			File ageProof) {
		super(firstName, lastName, email, phone, address, dateOfBirth);
		this.addressProof = addressProof;
		this.ageProof = ageProof;
	}

	public File getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(File addressProof) {
		this.addressProof = addressProof;
	}

	public File getAgeProof() {
		return ageProof;
	}

	public void setAgeProof(File ageProof) {
		this.ageProof = ageProof;
	}

	@Override
	public String toString() {
		return "Customer [addressProof=" + addressProof + ", ageProof="
				+ ageProof + "]";
	}

}
