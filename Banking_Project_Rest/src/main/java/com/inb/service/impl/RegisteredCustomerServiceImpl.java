package com.inb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inb.mongo.collections.Customer;
import com.inb.mongo.collections.RegisteredCustomer;
import com.inb.mongo.collections.UnregisteredCustomer;
import com.inb.mongo.repositories.RegisteredCustomerRepository;
import com.inb.mongo.repositories.UnregisteredCustomerRepository;
import com.inb.rest.entity.RegisteredCustomerPOJO;
import com.inb.service.interfaces.RegisteredCustomerService;

@Service
public class RegisteredCustomerServiceImpl implements RegisteredCustomerService {
	ObjectMapper mapper = new ObjectMapper();
	@Autowired
	RegisteredCustomerRepository registeredCustomerRepository;
	@Autowired
	UnregisteredCustomerRepository unregisteredCustomerRepository;

	public String registerEnquiry(RegisteredCustomerPOJO registeredCustomerPOJO) {
		String email = registeredCustomerPOJO.getEmail();
		List<Customer> list = unregisteredCustomerRepository
				.getUserByEmail(email);

		if (list.size() != 0) {
			return "{ \"Exception\":\"Application with same email is under Process\" , \"EnquiryId\" : \""
					+ list.get(0).getId() + "\" }";
		}

		Customer unregisteredCustomer = unregisteredCustomerRepository
				.save(registeredCustomerPOJOToPersonCollection(registeredCustomerPOJO));

		registeredCustomerRepository
				.save(registeredCustomerPOJOToRegisterCustomer(registeredCustomerPOJO));

		String json = "";
		if (unregisteredCustomer == null) {
			return "{ \"Exception\":\"User already Exist\" }";
		} else {
			ObjectMapper mapper = new ObjectMapper();

			try {
				json = mapper.writeValueAsString(unregisteredCustomer);
			} catch (JsonProcessingException e) {
				return "{\"Exception\":\"Parsing Error\"}";
			}

			return json;
		}
	}

	public Customer registeredCustomerPOJOToPersonCollection(
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
		registeredCustomer
				.setCustomerId(registeredCustomerPOJO.getCustomerId());
		return registeredCustomer;
	}

	public RegisteredCustomer registeredCustomerPOJOToRegisterCustomer(
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

	public String getRegisteredUserByClientId(String id) {
		List<RegisteredCustomer> list = registeredCustomerRepository
				.findBycustomerId(Long.parseLong(id));
		String json = "";
		if (list.size() == 0) {
			return "{ \"Exception\":\"No such user\" }";
		} else {
			ObjectMapper mapper = new ObjectMapper();

			try {
				json = mapper.writeValueAsString(list.get(0));
			} catch (JsonProcessingException e) {
				return "{\"Exception\":\"Parsing Error\"}";
			}
		}
		return json;

	}
	
	
	public String viewRegisteredUserDetails(String id)
			throws JsonProcessingException {
		String registeredUsersJson = "{ \"Error\": \"No Requests\"}";

		String idValue = id;
		List<RegisteredCustomer> listOfRegisteredUsers = registeredCustomerRepository
				.findById(idValue);

		if (listOfRegisteredUsers != null) {

			if (listOfRegisteredUsers.size() != 0)
				registeredUsersJson = mapper
						.writeValueAsString(listOfRegisteredUsers);
		}

		return registeredUsersJson;
	}

	public String viewRegisteredCustomers() throws JsonProcessingException {

		String registeredUsersJson = "No Results";
		List<RegisteredCustomer> listOfUsers = registeredCustomerRepository.findAll();

		if (listOfUsers != null) {
			registeredUsersJson = mapper.writeValueAsString(listOfUsers);
		}
		return registeredUsersJson;
	}
	public String getAuthorisationDataClientId(String id) {
		List<RegisteredCustomer> list = registeredCustomerRepository
				.findBycustomerId(Long.parseLong(id));
		String json = "";
		if (list.size() == 0) {
			return "{ \"Exception\":\"InvaildClientId\" }";
		} else {
			json = "{\"id\":\"" + list.get(0).getId() + "\",\"image\":\""
					+ list.get(0).getAuthorizedImageName() + "\",\"text\":\""
					+ list.get(0).getAuthorizedImageText() + "\"}";
		}
		System.out.println(json);

		// registeredCustomerRepository.save(new RegisteredCustomer("Navin",
		// "Maheshwari", "nm@gmail.com", 123456, "address", new Date(), 12345,
		// "NM", "nm", "one","navin is my name" ));
		return json;

	}
	
}
