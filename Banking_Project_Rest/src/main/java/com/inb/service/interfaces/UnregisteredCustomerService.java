package com.inb.service.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inb.mongo.collections.Customer;
import com.inb.rest.entity.UnregisteredCustomerPOJO;

public interface UnregisteredCustomerService {
	String registerEnquiry(UnregisteredCustomerPOJO unregisteredCustomerPOJO);
	public String isEmailAlreadyExits(String email);
	String verifyUnregisteredUsers(int skip, int limit) throws JsonProcessingException;
	String viewUnregisteredUserDetails(String id) throws JsonProcessingException;
	public Customer  getUserByEmail(String email);
	String sendEmail(String id,String applicationStatus);
}			