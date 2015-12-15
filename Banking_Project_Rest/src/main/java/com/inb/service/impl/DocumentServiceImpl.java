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
	// private FileOutputStream fout;

	ObjectMapper mapper = new ObjectMapper();

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
		Documents documents2 = documentsRepositiory.save(documents);
		if (documents2.getId() == null) {
			return false;
		} else {
			return true;
		}

	}

	public String retriveAddressProofDocumentForClientId(String id)
			throws JsonProcessingException {

		// Map<?, ?> jsonJavaRootObject = new Gson().fromJson(id, Map.class);
		// String idValue=(String) jsonJavaRootObject.get("id");
		String idValue = id;

		List<Documents> documents = documentsRepositiory.findById(idValue);
		System.out.println("-->" + documents);
		byte[] bytes = documents.get(0).getAddressProof();

		// fout = new FileOutputStream("D:/try.jpg");

		// fout.write(bytes);
		// System.out.println("copy done..");
		// stream.close();
		String retrieveUserDocumentsJson = mapper.writeValueAsString(bytes);

		return retrieveUserDocumentsJson;
	}

	public String retriveAgeProofDocumentForClientId(String id)
			throws JsonProcessingException {

		// Map<?, ?> jsonJavaRootObject = new Gson().fromJson(id, Map.class);
		// String idValue=(String) jsonJavaRootObject.get("id");
		String idValue = id;
		List<Documents> documents = documentsRepositiory.findById(idValue);
		System.out.println("-->" + documents);
		byte[] bytes = documents.get(0).getAgeProof();

		// fout = new FileOutputStream("D:/try.jpg");

		// fout.write(bytes);
		// System.out.println("copy done..");
		// stream.close();
		String retrieveUserDocumentsJson = mapper.writeValueAsString(bytes);

		return retrieveUserDocumentsJson;
	}

}
