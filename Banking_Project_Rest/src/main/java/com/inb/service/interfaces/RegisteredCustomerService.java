package com.inb.service.interfaces;

import com.inb.rest.entity.RegisteredCustomerPOJO;

public interface RegisteredCustomerService {
	String registerEnquiry(RegisteredCustomerPOJO registeredCustomerPOJO);
	String getRegisteredUserById(String id);
}
