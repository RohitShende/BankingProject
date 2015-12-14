package com.inb.service.interfaces;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.inb.rest.entity.UnregisteredCustomerPOJO;

public interface UnregisteredCustomerService {
	String registerEnquiry(UnregisteredCustomerPOJO unregisteredCustomerPOJO);
	
	String verifyUnregisteredUsers() throws JsonProcessingException;
	String viewUnregisteredUserDetails(String id) throws JsonProcessingException;
	String sendEmail(String id) throws JsonParseException, JsonMappingException, IOException;
}
			