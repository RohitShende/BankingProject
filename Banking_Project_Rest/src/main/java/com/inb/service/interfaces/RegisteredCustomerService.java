package com.inb.service.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inb.rest.entity.RegisteredCustomerPOJO;

public interface RegisteredCustomerService {
	String registerEnquiry(RegisteredCustomerPOJO registeredCustomerPOJO);
	String getRegisteredUserById(String id);
	
	public String viewRegisteredUserDetails(String id)
			throws JsonProcessingException;
	
	public String viewRegisteredCustomers()
			throws JsonProcessingException;
}
