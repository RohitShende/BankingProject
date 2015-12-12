package com.inb.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inb.mongo.collections.Documents;
import com.inb.mongo.repositories.DocumentsRepositiory;
import com.inb.service.interfaces.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentsRepositiory documentsRepositiory;
	private FileOutputStream fout;

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

	public Documents retriveDocumentForClientId(String id) {
		try {
			id = "123";
			List<Documents> documents = documentsRepositiory.findById(id);
			System.out.println("-->"+documents);
			byte[] bytes = documents.get(0).getAgeProof();
			fout = new FileOutputStream("D:/try.jpg");
			
			fout.write(bytes);
			System.out.println("copy done..");
			//stream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
