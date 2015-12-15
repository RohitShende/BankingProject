package com.inb.service.interfaces;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inb.mongo.collections.Documents;

public interface DocumentService {

	
	public String retriveAgeProofDocumentForClientId(String id) throws JsonProcessingException;
	public String retriveAddressProofDocumentForClientId(String id) throws JsonProcessingException;
	public String uploadDocument(MultipartFile addressProof , MultipartFile ageProof , String id);
}
