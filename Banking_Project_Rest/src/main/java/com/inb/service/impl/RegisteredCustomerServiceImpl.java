package com.inb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inb.mongo.collections.RegisteredCustomer;
import com.inb.mongo.repositories.RegisteredCustomerRepository;
import com.inb.mongo.repositories.UnregisteredCustomerRepository;
import com.inb.rest.entity.RegisteredCustomerPOJO;
import com.inb.service.interfaces.RegisteredCustomerService;

public class RegisteredCustomerServiceImpl implements RegisteredCustomerService {
	ObjectMapper mapper = new ObjectMapper();
	private ApplicationContext context;
	@Autowired
	RegisteredCustomerRepository registeredCustomerRepository;
	@Autowired
	UnregisteredCustomerRepository unregisteredCustomerRepository;

	public String registerEnquiry(RegisteredCustomerPOJO registeredCustomerPOJO) {
		return null;

	}

	public RegisteredCustomer registeredCustomerPOJOToRegisteredCustomer(
			RegisteredCustomerPOJO registeredCustomerPOJO) {
		RegisteredCustomer registeredCustomer = new RegisteredCustomer();
		registeredCustomer.setAccounthash(registeredCustomerPOJO
				.getAccounthash());
		registeredCustomer.setFirstName(registeredCustomerPOJO.getFirstName());
		registeredCustomer.setAddress(registeredCustomerPOJO.getAddress());
		registeredCustomer.setDateOfBirth(registeredCustomerPOJO
				.getDateOfBirth());
		registeredCustomer.setEmail(registeredCustomerPOJO.getEmail());
		registeredCustomer.setCustomerId(registeredCustomer.getCustomerId());
		registeredCustomer.setLastName(registeredCustomerPOJO.getLastName());
		registeredCustomer.setPhone(registeredCustomerPOJO.getPhone());
		return registeredCustomer;
	}

}
