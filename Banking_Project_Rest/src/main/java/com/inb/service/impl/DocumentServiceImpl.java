package com.inb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inb.mongo.collections.Documents;
import com.inb.mongo.repositories.DocumentsRepositiory;
import com.inb.service.interfaces.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentsRepositiory documentsRepositiory;

	ObjectMapper mapper = new ObjectMapper();

	
	/*--------------Upload Document Service--------------*/
	public String uploadDocument(MultipartFile addressProof,
			MultipartFile ageProof, String id) {

		if (!ageProof.isEmpty() && !addressProof.isEmpty()) {
			try {
				Documents documents = new Documents();
				documents.setAddressProof(addressProof.getBytes());
				documents.setAgeProof(ageProof.getBytes());
				documents.setUserId(id);
				if (uploadDocument(documents)) {
					return "{\"Message\":\"SucessTRY\"}";
				}else
				{
					return "{\"Message\":\"Error\"}";
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "{\"Message\":\"Exception@server\"}";
			}
		} else {
			return "{\"Message\":\"File Empty\"}";
		}
	}

	public boolean uploadDocument(Documents documents) {
		Documents documents2 = documentsRepositiory.insert(documents);
		if (documents2.getId() == null) {
			return false;
		} else {
			return true;
		}

	}

	/*--------------View Address Proof Document Service--------------*/
	public String retriveAddressProofDocumentForClientId(String id)
			throws JsonProcessingException {
		String idValue = id;

		List<Documents> documents = documentsRepositiory.findByUserId(idValue);
		if(documents.size()!=0)	
		{
			byte[] bytes = documents.get(0).getAddressProof();
			String retrieveUserDocumentsJson = mapper.writeValueAsString(bytes);

			return retrieveUserDocumentsJson;
		}
		return "{\"Error\":\"No address proof document uploaded\"}";
	}

	/*--------------View Age Proof Document Service--------------*/
	public String retriveAgeProofDocumentForClientId(String id)
			throws JsonProcessingException {

		String idValue = id;
		List<Documents> documents = documentsRepositiory.findByUserId(idValue);
		if(documents.size()!=0)	
		{
			byte[] bytes = documents.get(0).getAgeProof();
			String retrieveUserDocumentsJson = mapper.writeValueAsString(bytes);
			return retrieveUserDocumentsJson;
		}
		return "{\"Error\":\"No age proof document uploaded\"}";
	}

}
