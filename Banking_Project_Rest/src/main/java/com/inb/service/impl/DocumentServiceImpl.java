package com.inb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.inb.mongo.collections.Documents;
import com.inb.mongo.repositories.DocumentsRepositiory;
import com.inb.service.interfaces.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentsRepositiory documentsRepositiory;
//	private FileOutputStream fout;

	ObjectMapper mapper = new ObjectMapper();
	
	public String uploadDocument(Documents documents) {
		Documents documents2 = documentsRepositiory.save(documents);

		String json = "";

		if (documents2.getId() == null) {
			return "{ \"Exception\":\"Not Inserted\" }";
		} else {
			ObjectMapper mapper = new ObjectMapper();
			try {
				json = mapper.writeValueAsString(documents2);
			} catch (JsonProcessingException e) {
				return "{\"Exception\":\"Parsing Error\"}";
			}
			return json;
		}

	}

	public String retriveAddressProofDocumentForClientId(String id) throws JsonProcessingException {
	
		Map<?, ?> jsonJavaRootObject = new Gson().fromJson(id, Map.class);
        String idValue=(String) jsonJavaRootObject.get("id");
        
        
			List<Documents> documents = documentsRepositiory.findById(idValue);
			System.out.println("-->"+documents);
			byte[] bytes = documents.get(0).getAddressProof();
			
		
			//fout = new FileOutputStream("D:/try.jpg");
	
			//fout.write(bytes);
			//System.out.println("copy done..");
			//stream.close();
			String retrieveUserDocumentsJson=mapper.writeValueAsString(bytes);
		
		return retrieveUserDocumentsJson;
	}

	public String retriveAgeProofDocumentForClientId(String id) throws JsonProcessingException {

		Map<?, ?> jsonJavaRootObject = new Gson().fromJson(id, Map.class);
        String idValue=(String) jsonJavaRootObject.get("id");
        
			List<Documents> documents = documentsRepositiory.findById(idValue);
			System.out.println("-->"+documents);
			byte[] bytes = documents.get(0).getAgeProof();
			
	
			//fout = new FileOutputStream("D:/try.jpg");
	
			//fout.write(bytes);
			//System.out.println("copy done..");
			//stream.close();
			String retrieveUserDocumentsJson=mapper.writeValueAsString(bytes);
		
		return retrieveUserDocumentsJson;
	}
	
}
