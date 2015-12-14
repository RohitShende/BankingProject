package com.inb.service.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inb.mongo.collections.Documents;

public interface DocumentService {

	public String uploadDocument(Documents documents);
	public String retriveAgeProofDocumentForClientId(String id) throws JsonProcessingException;
	public String retriveAddressProofDocumentForClientId(String id) throws JsonProcessingException;
}
