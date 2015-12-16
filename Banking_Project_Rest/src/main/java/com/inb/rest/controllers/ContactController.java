package com.inb.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inb.mongo.collections.Contact;
import com.inb.rest.entity.ContactPOJO;
import com.inb.service.interfaces.ContactService;


@CrossOrigin
@RestController
public class ContactController {

ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(value="/contact", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createContact(@RequestBody ContactPOJO contact) throws JsonProcessingException {
			
			String result=contactService.add(new Contact(contact.getFirstName(),contact.getLastName(),
					contact.getEmail(),contact.getPhone(),contact.getMessage()));
			
			return result;
	}
	
}
