package com.inb.service.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inb.mongo.collections.Customer;
import com.inb.mongo.collections.RegisteredCustomer;
import com.inb.mongo.collections.UnregisteredCustomer;
import com.inb.mongo.repositories.RegisteredCustomerRepository;
import com.inb.mongo.repositories.UnregisteredCustomerRepository;
import com.inb.rest.entity.Account;
import com.inb.rest.entity.UnregisteredCustomerPOJO;
import com.inb.service.interfaces.UnregisteredCustomerService;
import com.inb.util.MailMail;
import com.inb.util.RandomNumberGenerator;

@Service
public class UnregisteredCustomerServiceImpl implements
		UnregisteredCustomerService {

	ObjectMapper mapper = new ObjectMapper();
	private ApplicationContext context;
	@Autowired
	UnregisteredCustomerRepository unregisteredCustomerRepository;

	@Autowired
	RegisteredCustomerRepository registeredCustomerRepository;
	
	@Autowired
	MongoOperations mongoOperations;
	
	
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
		
		Customer customer = getUserByEmail(email);
		String json = "";
		if (customer != null) {
			
			ObjectMapper mapper = new ObjectMapper();
			try {
				json = mapper.writeValueAsString(customer);
			} catch (JsonProcessingException e) {
				return "{\"Exception\":\"Parsing Error\"}";
			}
			
			return json;
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
		unregisteredCustomer.setApplicationStatus("Pending");
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
	
	public Customer  getUserByEmail(String email) {
		String emailValue = email;
		System.out.println("--->" + emailValue);
		List<Customer> list = unregisteredCustomerRepository
				.getUserByEmail(emailValue);
		System.out.println("--->" + list.size());
		if (list.size() != 0) {
			
			return list.get(0);
		}
		return null;
	}

public String sendEmail(String id,String applicationStatus) {
		
		List<Customer> listOfUnregisteredUsers=unregisteredCustomerRepository.findById(id);
		Customer unregisteredPerson=listOfUnregisteredUsers.get(0);
	
		if(applicationStatus.equals("reject"))
		{
			UnregisteredCustomer unregisteredCustomer=(UnregisteredCustomer)unregisteredPerson;
			unregisteredCustomer.setApplicationStatus("Rejected");
			
			unregisteredCustomerRepository.save(unregisteredCustomer);
			String emailMessageBody="Your application has been rejected. Please contact your nearest branch "
					+ "manager for more details";
			
			String receiverEmailId=unregisteredCustomer.getEmail();
			
			context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
					MailMail mm = (MailMail) context.getBean("mailMail");
			        mm.sendMail("from@no-spam.com",
			        		receiverEmailId,
			    		   "Verification Email for bank account",
			    		   emailMessageBody);
		}
		else
		{
			RegisteredCustomer registeredCustomer=new RegisteredCustomer();
			String emailMessageBody="";
			
			String oneTimePassword=Integer.toString(RandomNumberGenerator.randomWithRange(1000, 5000));
	
			long accountNumber=RandomNumberGenerator.randomWithRange(1000, 500000);
			long clientId=RandomNumberGenerator.randomWithRange(3000, 500000);
			
			
			List<RegisteredCustomer> listOfRegisteredUsers=registeredCustomerRepository.findById(id);
			
				if(listOfRegisteredUsers.size()==0 || !(listOfRegisteredUsers.get(0).getId().equals(id)))
				{
					
					HashSet<Account> accounthash=new HashSet<Account>();
					Account unregisteredCustomerAccount=new Account();
					unregisteredCustomerAccount.setAccountNumber(accountNumber);
					
					accounthash.add(unregisteredCustomerAccount);
					
					registeredCustomer=registeredCustomerRepository.insert(new RegisteredCustomer(unregisteredPerson.getFirstName(), unregisteredPerson.getLastName(), 
						unregisteredPerson.getEmail(), unregisteredPerson.getPhone(),unregisteredPerson.getAddress(), 
						unregisteredPerson.getDateOfBirth(),clientId, oneTimePassword,accounthash));
					emailMessageBody="Your Client Id is: "+clientId+" and one time password: "+oneTimePassword;
					
					unregisteredCustomerRepository.delete(id);
				}	
				
			
			else
			{
				HashSet<Account> accounthash=listOfRegisteredUsers.get(0).getAccounthash();
				Account unregisteredCustomerAccount=new Account();
				unregisteredCustomerAccount.setAccountNumber(accountNumber);
				accounthash.add(unregisteredCustomerAccount);
				
				mongoOperations.save(listOfRegisteredUsers.get(0));
				
				emailMessageBody="Your Account Number is: " +accountNumber;
				
				unregisteredCustomerRepository.delete(id);
			}
		
			String receiverEmailId=registeredCustomer.getEmail();
			System.out.println("message body "+emailMessageBody);
			context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
			MailMail mm = (MailMail) context.getBean("mailMail");
	        mm.sendMail("from@no-spam.com",
	        		receiverEmailId,
	    		   "Verification Email for bank account",
	    		   emailMessageBody);
		}
		
		return "Success";
	}


}
