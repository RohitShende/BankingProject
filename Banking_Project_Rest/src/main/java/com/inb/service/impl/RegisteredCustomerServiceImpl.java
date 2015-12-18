package com.inb.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inb.mongo.collections.Customer;
import com.inb.mongo.collections.RegisteredCustomer;
import com.inb.mongo.repositories.RegisteredCustomerRepository;
import com.inb.mongo.repositories.UnregisteredCustomerRepository;
import com.inb.rest.entity.Account;
import com.inb.rest.entity.RegisteredCustomerPOJO;
import com.inb.rest.entity.TransferPOJO;
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
		registeredCustomer.setApplicationStatus("Pending");
		return registeredCustomer;
	}

	public String getRegisteredUserByClientId(String id) {
		RegisteredCustomer registeredCustomer = getRegisteredUserObjectByClientId(id);
		String json;
		if (registeredCustomer == null) {
			return "{ \"Exception\":\"No such user\" }";
		} else {
			ObjectMapper mapper = new ObjectMapper();

			try {
				json = mapper.writeValueAsString(registeredCustomer);
			} catch (JsonProcessingException e) {
				return "{\"Exception\":\"Parsing Error\"}";
			}
		}
		return json;

	}

	public RegisteredCustomer getRegisteredUserObjectByClientId(String id) {
		List<RegisteredCustomer> list = registeredCustomerRepository
				.findBycustomerId(Long.parseLong(id));
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
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

		String registeredUsersJson = "{ \"Error\": \"No Results\"}";
		List<RegisteredCustomer> listOfUsers = registeredCustomerRepository
				.findAll();

		if (listOfUsers != null) {
			registeredUsersJson = mapper.writeValueAsString(listOfUsers);
		}
		return registeredUsersJson;
	}

	public String getAuthorisationDataClientId(String id) {
		String json = "";
		try {
			List<RegisteredCustomer> list = registeredCustomerRepository
					.findBycustomerId(Long.parseLong(id));

			if (list.size() == 0) {
				return "{ \"Exception\":\"Invaild Customer Id\" }";
			} else {
				if (list.get(0).getAuthorizedImageText() == null) {
					json = "{\"id\":\"" + list.get(0).getCustomerId()
							+ "\",\"firstTimeLogin\":\"true\"}";
				} else {
					json = "{\"id\":\"" + list.get(0).getId()
							+ "\",\"image\":\""
							+ list.get(0).getAuthorizedImageName()
							+ "\",\"text\":\""
							+ list.get(0).getAuthorizedImageText() + "\"}";
				}
			}
		} catch (Exception e) {
			return "{ \"Exception\":\"Invaild Customer Id\" }";
		}
		return json;

	}

	public String checkLogin(String clientId, String password) {
		RegisteredCustomer registeredCustomer = getRegisteredUserObjectByClientId(clientId);
		String json = "{\"Exception\":\"Invalid credentials\"}";
		if (registeredCustomer != null
				&& registeredCustomer.getPassword().equalsIgnoreCase(password)) {
			ObjectMapper mapper = new ObjectMapper();

			try {
				json = mapper.writeValueAsString(registeredCustomer);
			} catch (JsonProcessingException e) {
				return "{\"Exception\":\"Parsing Error\"}";
			}
		}
		return json;
	}

	public String setAuthorisationOfRegisteredUser(
			RegisteredCustomer registeredCustomer) {
		RegisteredCustomer tempRegisteredCustomer = getRegisteredUserObjectByClientId(""
				+ registeredCustomer.getCustomerId());
		tempRegisteredCustomer.setAuthorizedImageName(registeredCustomer
				.getAuthorizedImageName());
		tempRegisteredCustomer.setAuthorizedImageText(registeredCustomer
				.getAuthorizedImageText());
		tempRegisteredCustomer.setPassword(registeredCustomer.getPassword());
		registeredCustomer = registeredCustomerRepository
				.save(tempRegisteredCustomer);
		String json = "";
		try {
			json = mapper.writeValueAsString(registeredCustomer);
		} catch (JsonProcessingException e) {
			return "{\"Exception\":\"Parsing Error\"}";
		}
		return json;
	}

	public String transferMoney(TransferPOJO transfer) {

		List<RegisteredCustomer> list = registeredCustomerRepository
				.findByAccountNumber(transfer.getClientAccount());
		RegisteredCustomer registeredCustomerSender = list.size() == 0 ? null
				: list.get(0);

		RegisteredCustomer registeredCustomerReciver;

		list = registeredCustomerRepository.findByAccountNumber(transfer
				.getRecevierAccount());

		registeredCustomerReciver = list.size() == 0 ? null : list.get(0);
		if (registeredCustomerReciver == null
				|| registeredCustomerSender == null) {
			return "{\"Status\":\"Failed\", \"Message\":\"Low Balance1\"}";
		}

		if (registeredCustomerReciver.getCustomerId() != registeredCustomerSender
				.getCustomerId()) { // if client is transferring to others
									// account

			Iterator<Account> clientAccounts = registeredCustomerSender
					.getAccounthash().iterator();
			boolean fineFlag = true;
			Account senderAccount = null;

			while (clientAccounts.hasNext()) {
				Account temp = clientAccounts.next();

				if (temp.getAccountNumber() == transfer.getClientAccount()) {
					senderAccount = temp;
					if (temp.getBalance() < transfer.getAmount()) {
						fineFlag = false;
						return "{\"Status\":\"Failed\", \"Message\":\"Low Balance1\"}";
					}
					break;
				}
			}

			Iterator<Account> reciverAccountsIterator = registeredCustomerReciver
					.getAccounthash().iterator();
			Account reciverAccount = null;
			while (reciverAccountsIterator.hasNext()) {
				Account temp = reciverAccountsIterator.next();

				if (temp.getAccountNumber() == transfer.getRecevierAccount()) {
					reciverAccount = temp;
					break;
				}
			}
			senderAccount.setBalance(senderAccount.getBalance()
					- transfer.getAmount());
			reciverAccount.setBalance(reciverAccount.getBalance()
					+ transfer.getAmount());
			if(fineFlag){
				registeredCustomerRepository.save(registeredCustomerSender);
				registeredCustomerRepository.save(registeredCustomerReciver);
				return "{\"Status\":\"Success\", \"Message\":\"Done Successfully\"}";
			}else
			{
				return "{\"Status\":\"Failed\", \"Message\":\"Low Balance1\"}";
			}
		} else // (registeredCustomerReciver.getCustomerId()!=registeredCustomerSender.getCustomerId())
				// // if client is transfering to his own account
		{

			Iterator<Account> clientAccounts = registeredCustomerSender
					.getAccounthash().iterator();
			boolean fineFlag = true;
			Account senderAccount = null;
			Account reciverAccount = null;
			while (clientAccounts.hasNext()) {
				Account temp = clientAccounts.next();

				if (temp.getAccountNumber() == transfer.getClientAccount()) {
					senderAccount = temp;
					if (temp.getBalance() < transfer.getAmount()) {
						fineFlag = false;
						return "{\"Status\":\"Failed\", \"Message\":\"Low Balance1\"}";
					}

				}
				if (temp.getAccountNumber() == transfer.getRecevierAccount()) {
					reciverAccount = temp;
				}
			}

			senderAccount.setBalance(senderAccount.getBalance()
					- transfer.getAmount());
			reciverAccount.setBalance(reciverAccount.getBalance()
					+ transfer.getAmount());
			if(fineFlag){
				registeredCustomerRepository.save(registeredCustomerSender);
				return "{\"Status\":\"Success\", \"Message\":\"Done Successfully\"}";
			}else
			{
				return "{\"Status\":\"Failed\", \"Message\":\"Low Balance1\"}";
			}
		}

	}

	public String viewAccountDetails(long id) throws JsonProcessingException {
		String accountDetailsJson = "{\"Error\":\"No accounts to display\"}";
		List<RegisteredCustomer> listOfUsers = registeredCustomerRepository
				.findBycustomerId(id);
		if (listOfUsers.get(0).getAccounthash() != null) {
			accountDetailsJson = mapper.writeValueAsString(listOfUsers.get(0)
					.getAccounthash());
		}
		return accountDetailsJson;
	}

}
