package com.inb.mongo.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "documents")
public class Documents {
	@Id
	String id;
	private String userId;
	private byte[] addressProof;
	private byte[] ageProof;

	public Documents() {
		super();
	}

	public Documents(String clientId, byte[] addressProof, byte[] ageProof) {
		super();
		this.userId = clientId;
		this.addressProof = addressProof;
		this.ageProof = ageProof;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
