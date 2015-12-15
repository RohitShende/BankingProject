package com.inb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.inb.mongo.collections.Customer;
import com.inb.mongo.collections.UnregisteredCustomer;
import com.inb.mongo.repositories.UnregisteredCustomerRepository;
import com.inb.rest.entity.UnregisteredCustomerPOJO;
import com.inb.service.interfaces.UnregisteredCustomerService;
import com.inb.util.MailMail;

@Service
public class UnregisteredCustomerServiceImpl implements
		UnregisteredCustomerService {

	ObjectMapper mapper = new ObjectMapper();
	private ApplicationContext context;
	@Autowired
	UnregisteredCustomerRepository unregisteredCustomerRepository;

	public String registerEnquiry(

	UnregisteredCustomerPOJO unregisteredCustomerPOJO) {
		UnregisteredCustomer unregisteredCustomer = unregisteredCustomerRepository
				.save(unregisteredCustomerPOJOTounregisteredCustomer(unregisteredCustomerPOJO));
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

	public String isEmailAlreadyExits(String email) {
		// Map<?, ?> jsonJavaRootObject = new Gson().fromJson(email, Map.class);
		// String emailValue = (String) jsonJavaRootObject.get("email");
		String emailValue = email;
		System.out.println("--->" + emailValue);
		List<Customer> list = unregisteredCustomerRepository
				.getUserByEmail(emailValue);

		System.out.println("--->" + list.size());
		if (list.size() != 0) {
			return "{ \"alreadyExists\":\"true\" }";
		}
		return "{\"alreadyExists\" : \"false\"}";
	}

	public UnregisteredCustomer unregisteredCustomerPOJOTounregisteredCustomer(
			UnregisteredCustomerPOJO unregisteredCustomerPOJO) {
		UnregisteredCustomer unregisteredCustomer = new UnregisteredCustomer();
		unregisteredCustomer.setAccount(unregisteredCustomerPOJO.getAccount());
		unregisteredCustomer.setFirstName(unregisteredCustomerPOJO
				.getFirstName());
		unregisteredCustomer.setAddress(unregisteredCustomerPOJO.getAddress());
		unregisteredCustomer.setDateOfBirth(unregisteredCustomerPOJO
				.getDateOfBirth());
		unregisteredCustomer.setEmail(unregisteredCustomerPOJO.getEmail());
		unregisteredCustomer.setEnqId(unregisteredCustomerPOJO.getEnqId());
		unregisteredCustomer
				.setLastName(unregisteredCustomerPOJO.getLastName());
		unregisteredCustomer.setPhone(unregisteredCustomerPOJO.getPhone());
		return unregisteredCustomer;
	}

	public String verifyUnregisteredUsers() throws JsonProcessingException {

		String unregisteredUsersJson = "No Requests";
		List<Customer> listOfUsers = unregisteredCustomerRepository.findAll();

		if (listOfUsers != null) {
			unregisteredUsersJson = mapper.writeValueAsString(listOfUsers);
		}
		return unregisteredUsersJson;
	}

	public String viewUnregisteredUserDetails(String id)
			throws JsonProcessingException {
		String unregisteredUsersJson = "{ \"Error\": \"No Requests\"}";

		//
		// Map<?, ?> jsonJavaRootObject = new Gson().fromJson(id, Map.class);

		// String idValue = (String) jsonJavaRootObject.get("id");
		String idValue = id;
		List<Customer> listOfRequests = unregisteredCustomerRepository
				.findById(idValue);

		if (listOfRequests != null) {

			if (listOfRequests.size() != 0)
				unregisteredUsersJson = mapper
						.writeValueAsString(listOfRequests);
		}

		return unregisteredUsersJson;
	}

	public String sendEmail(String id) {

		// Map<?, ?> jsonJavaRootObject = new Gson().fromJson(id, Map.class);
		// String idValue = (String) jsonJavaRootObject.get("id");
		String idValue = id;
		List<Customer> list = unregisteredCustomerRepository.findById(idValue);
		String receiverEmailId = list.get(0).getEmail();

		context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
		MailMail mm = (MailMail) context.getBean("mailMail");
		mm.sendMail("from@no-spam.com", receiverEmailId,
				"Verification Email for bank account",
				"Click this link to complete your sign up process");
		return "Success";
	}
}
