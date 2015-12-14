package com.inb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inb.mongo.collections.Contact;
import com.inb.mongo.repositories.ContactRepository;
import com.inb.service.interfaces.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private MongoOperations mongoOperations;

	@Autowired
	private ContactRepository contactRepository;
	
	ObjectMapper mapper = new ObjectMapper();
	
	public String insert(Contact contact) throws JsonProcessingException {
		String contactJson;
		
			contactRepository.insert(contact);
			contactJson = mapper.writeValueAsString(contact);
		
		return contactJson;
	}

}
