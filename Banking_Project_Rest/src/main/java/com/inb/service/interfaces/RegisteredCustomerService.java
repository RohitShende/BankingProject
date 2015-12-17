package com.inb.service.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inb.mongo.collections.RegisteredCustomer;
import com.inb.rest.entity.RegisteredCustomerPOJO;

public interface RegisteredCustomerService {
	String registerEnquiry(RegisteredCustomerPOJO registeredCustomerPOJO);
	String getRegisteredUserByClientId(String id);
	String getAuthorisationDataClientId(String id); 
	String checkLogin(String clientId , String password);
	RegisteredCustomer getRegisteredUserObjectByClientId(String id);
	String transferMoney(String accountNo,String receiverAccount,float amount);
	
	
	String setAuthorisationOfRegisteredUser(RegisteredCustomer registeredCustomer);
	public String viewRegisteredUserDetails(String id)
			throws JsonProcessingException;
	
	public String viewRegisteredCustomers()
			throws JsonProcessingException;
	
	String viewAccountDetails(long id) throws JsonProcessingException;
}
