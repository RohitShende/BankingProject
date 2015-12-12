package com.inb.rest.entity;

public class DocumentPOJO {

	private String userId;
	private byte[] addressProof;
	private byte[] ageProof;

	public DocumentPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocumentPOJO(String userId, byte[] addressProof, byte[] ageProof) {
		super();
		this.userId = userId;
		this.addressProof = addressProof;
		this.ageProof = ageProof;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public byte[] getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(byte[] addressProof) {
		this.addressProof = addressProof;
	}

	public byte[] getAgeProof() {
		return ageProof;
	}

	public void setAgeProof(byte[] ageProof) {
		this.ageProof = ageProof;
	}

	@Override
	public String toString() {
		return "Customer [addressProof=" + addressProof + ", ageProof="
				+ ageProof + super.toString() + "]";
	}

}
