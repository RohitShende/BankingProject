package com.inb.service.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inb.mongo.collections.Branch;
import com.inb.mongo.collections.Customer;
import com.inb.mongo.collections.Documents;
import com.inb.mongo.collections.RegisteredCustomer;
import com.inb.mongo.collections.UnregisteredCustomer;
import com.inb.mongo.repositories.BranchRepository;
import com.inb.mongo.repositories.DocumentsRepositiory;
import com.inb.mongo.repositories.RegisteredCustomerRepository;
import com.inb.mongo.repositories.UnregisteredCustomerRepository;
import com.inb.rest.entity.Account;
import com.inb.rest.entity.BranchPOJO;
import com.inb.rest.entity.UnregisteredCustomerPOJO;
import com.inb.service.interfaces.UnregisteredCustomerService;
import com.inb.util.MailMail;
import com.inb.util.RandomNumberGenerator;

@Service
public class UnregisteredCustomerServiceImpl implements UnregisteredCustomerService {

	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	MailMail mailService;

	@Autowired
	UnregisteredCustomerRepository unregisteredCustomerRepository;

	@Autowired
	RegisteredCustomerRepository registeredCustomerRepository;

	@Autowired
	MongoOperations mongoOperations;

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private DocumentsRepositiory documentsRepositiory;

	@SuppressWarnings("unused")
	private String emailMessageBody;

	@SuppressWarnings("unused")
	private String receiverEmailId;

	@SuppressWarnings("unused")
	private String emailMessageBody2;

	@SuppressWarnings("unused")
	private String receiverEmailId2;

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
				List<Documents> list = documentsRepositiory.findByUserId(customer.getId());
				if (list.size() == 0) {
					json = mapper.writeValueAsString(customer);

				} else {
					json = "{\"Status\":\"DocumentSubmitted\",\"id\":\"" + customer.getId() + "\"}";
				}

			} catch (JsonProcessingException e) {
				return "{\"Exception\":\"Parsing Error\"}";
			}

			return json;
		} else {
			List<RegisteredCustomer> listRegisteredCustomers = registeredCustomerRepository.findByEmail(email);
			if (listRegisteredCustomers.size() != 0) {
				return "{\"AlreadyUser\" : \"true\"}";
			}
		}
		return "{\"alreadyExists\" : \"false\"}";
	}

	public UnregisteredCustomer unregisteredCustomerPOJOTounregisteredCustomer(
			UnregisteredCustomerPOJO unregisteredCustomerPOJO) {

		UnregisteredCustomer unregisteredCustomer = new UnregisteredCustomer();
		unregisteredCustomer.setAccount(unregisteredCustomerPOJO.getAccount());
		unregisteredCustomer.setFirstName(unregisteredCustomerPOJO.getFirstName());
		unregisteredCustomer.setAddress(unregisteredCustomerPOJO.getAddress());
		unregisteredCustomer.setDateOfBirth(unregisteredCustomerPOJO.getDateOfBirth());
		unregisteredCustomer.setEmail(unregisteredCustomerPOJO.getEmail());
		unregisteredCustomer.setEnqId(unregisteredCustomerPOJO.getEnqId());
		unregisteredCustomer.setLastName(unregisteredCustomerPOJO.getLastName());
		unregisteredCustomer.setPhone(unregisteredCustomerPOJO.getPhone());
		unregisteredCustomer.setApplicationStatus("Pending");

		unregisteredCustomer.setBranch(convertBranchPOJOToBranch(unregisteredCustomerPOJO.getBranchPOJO()));

		return unregisteredCustomer;
	}

	public String verifyUnregisteredUsers() throws JsonProcessingException {

		String unregisteredUsersJson = "{ \"Error\": \"No Requests\"}";
		List<Customer> listOfUsers = unregisteredCustomerRepository.findAll();

		if (listOfUsers != null) {
			unregisteredUsersJson = mapper.writeValueAsString(listOfUsers);
		}
		return unregisteredUsersJson;
	}

	public String viewUnregisteredUserDetails(String id) throws JsonProcessingException {
		String unregisteredUsersJson = "{ \"Error\": \"No Requests\"}";
		String idValue = id;
		List<Customer> listOfRequests = unregisteredCustomerRepository.findById(idValue);

		if (listOfRequests != null) {

			if (listOfRequests.size() != 0)
				unregisteredUsersJson = mapper.writeValueAsString(listOfRequests);
		}

		return unregisteredUsersJson;
	}

	public Customer getUserByEmail(String email) {
		String emailValue = email;

		List<Customer> list = unregisteredCustomerRepository.getUserByEmail(emailValue);

		if (list.size() != 0) {

			return list.get(0);
		}
		return null;
	}

	public String sendEmail(String id, String applicationStatus) throws ClassNotFoundException {
		
		
		
		List<Customer> listOfUnregisteredUsers = unregisteredCustomerRepository.findById(id);
		long existingClientId = 0l;
		System.out.println(listOfUnregisteredUsers.get(0).getClass().equals(Class.forName("com.inb.mongo.collections.RegisteredCustomer")));
		if(listOfUnregisteredUsers.get(0).getClass().equals(Class.forName("com.inb.mongo.collections.RegisteredCustomer")))
		{
			System.out.println("injsidejedfjkdseif" );
			existingClientId=(((RegisteredCustomer)listOfUnregisteredUsers.get(0)).getCustomerId());
		}
		String accountTypeString="";

		
		System.out.println(existingClientId);
		
		
		String result = "{ \"Error\": \"Email not sent\"}";
		if (listOfUnregisteredUsers.size() != 0) {

			Customer unregisteredPerson = listOfUnregisteredUsers.get(0);
			//UnregisteredCustomer unregisteredPerson = (UnregisteredCustomer) listOfUnregisteredUsers.get(0);

			if (applicationStatus.equals("reject")) {
				UnregisteredCustomer unregisteredCustomer = (UnregisteredCustomer) unregisteredPerson;
				unregisteredCustomer.setApplicationStatus("Rejected");

				unregisteredCustomerRepository.save(unregisteredCustomer);
				emailMessageBody = "Your application has been rejected. Please contact your nearest branch "
						+ "manager for more details";

				result = "{ \"Success\": \"Email sent\"}";
				receiverEmailId = unregisteredCustomer.getEmail();

				// mailService.sendMail("info.inbbank@gmail.com",
				// receiverEmailId,
				// "Verification Email for bank account",
				// emailMessageBody);
			} else {
				RegisteredCustomer registeredCustomer = new RegisteredCustomer();
				emailMessageBody2 = "";

				String oneTimePassword = Integer.toString(RandomNumberGenerator.randomWithRange(1000, 5000));

				long accountNumber = 0;
				boolean checkUniqueAccountNumber = true;
				while (checkUniqueAccountNumber) {
					checkUniqueAccountNumber = checkAccountNumber(accountNumber);
					accountNumber = RandomNumberGenerator.randomWithRange(1000, 500000);
				}

				
				List<RegisteredCustomer> listOfRegisteredUsers = registeredCustomerRepository.findBycustomerId(existingClientId);
				System.out.println("*** "+listOfRegisteredUsers);
				/* Case 1: New user */
				if (listOfRegisteredUsers.size() == 0 || !(listOfRegisteredUsers.get(0).getCustomerId()==existingClientId)) {

					boolean checkResult = true;
					long clientId = 0;
					while (checkResult) {
						clientId = RandomNumberGenerator.randomWithRange(3000, 500000);
						checkResult = checkClientId(clientId);

	
					}

					HashSet<Account> accounthash = new HashSet<Account>();
					Account unregisteredCustomerAccount = new Account();
					unregisteredCustomerAccount.setAccountNumber(accountNumber);
					unregisteredCustomerAccount.setBalance(5000);
					accounthash.add(unregisteredCustomerAccount);
					
					UnregisteredCustomer unregisteredCustomerRequest= (UnregisteredCustomer)unregisteredPerson;
					
					unregisteredCustomerAccount.setAccountType(unregisteredCustomerRequest.getAccount().getAccountType());
					

					registeredCustomer = registeredCustomerRepository
							.insert(new RegisteredCustomer(unregisteredPerson.getFirstName(),
									unregisteredPerson.getLastName(), unregisteredPerson.getEmail(),
									unregisteredPerson.getPhone(), unregisteredPerson.getAddress(),
									unregisteredPerson.getDateOfBirth(), clientId, oneTimePassword, accounthash,unregisteredPerson.getBranch()));
					emailMessageBody2 = "Your Client Id is: " + clientId + " and one time password: " + oneTimePassword
							+ ". Your account number is: " + accountNumber;
					result = "{ \"Success\": \"Email sent\"}";
					unregisteredCustomerRepository.delete(id);
				}

				/* Case 2: Registered Customer who has an account */
				else {
					
					System.out.println("inside else");
					
					HashSet<Account> accounthash = listOfRegisteredUsers.get(0).getAccounthash();
					Account registeredCustomerAccount = new Account();
					registeredCustomerAccount.setAccountNumber(accountNumber);
					registeredCustomerAccount.setBalance(5000);
					
					//UnregisteredCustomer unregisteredCustomerRequest= (UnregisteredCustomer)unregisteredPerson;
					
					//registeredCustomerAccount.setAccountType(unregisteredCustomerRequest.getAccount().getAccountType());
					accounthash.add(registeredCustomerAccount);

					//mongoOperations.save(listOfRegisteredUsers.get(0));
					registeredCustomerRepository.save(listOfRegisteredUsers.get(0));
					emailMessageBody2 = "Your account number is: " + accountNumber;
					result = "{ \"Success\": \"Email sent\"}";
					unregisteredCustomerRepository.delete(id);
				}

				receiverEmailId2 = registeredCustomer.getEmail();

				// mailService.sendMail("info.inbbank@gmail.com",
				// receiverEmailId,
				// "Verification Email for bank account",
				// emailMessageBody);

			}
		}
		return result;
	}

	private boolean checkClientId(long customerId) {
		List<RegisteredCustomer> listOfCustomers = registeredCustomerRepository.findBycustomerId(customerId);
		if (listOfCustomers.size() != 0) {
			return true;
		} else
			return false;
	}

	private boolean checkAccountNumber(long accountNumber) {
		List<RegisteredCustomer> listOfCustomers = registeredCustomerRepository.findByAccountNumber(accountNumber);
		if (listOfCustomers.size() != 0) {
			return true;
		} else
			return false;
	}

	private Branch convertBranchPOJOToBranch(BranchPOJO branchPOJO) {
		List<Branch> branchDetails = branchRepository.findByBranchName(branchPOJO.getBranchName());
		return branchDetails.get(0);
	}

}
