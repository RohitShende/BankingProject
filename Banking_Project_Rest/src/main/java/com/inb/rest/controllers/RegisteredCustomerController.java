/**
 * 
 */
package com.inb.rest.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inb.rest.entity.LoginDetails;
import com.inb.rest.entity.RegisteredCustomerPOJO;
import com.inb.service.interfaces.RegisteredCustomerService;

/**
 * @author shende_r
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value="/registeredcustomer")
public class RegisteredCustomerController {

	@Autowired
	private RegisteredCustomerService registeredCustomerService;

	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String registerEnquiry(
			@RequestBody RegisteredCustomerPOJO registeredCustomerPOJO) {
		return registeredCustomerService
				.registerEnquiry(registeredCustomerPOJO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getCustomerById(
			@PathVariable String id) {
		return registeredCustomerService
				.getRegisteredUserByClientId(id);
	}

	@RequestMapping(value="/details/{id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String viewRegisteredUsers(@PathVariable String id) throws JsonProcessingException
	{
		return registeredCustomerService.viewRegisteredUserDetails(id);
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String viewRegisteredCustomers() throws JsonProcessingException
	{
		return registeredCustomerService.viewRegisteredCustomers();
	}
	
	@RequestMapping(value="/",method=RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String loginRegisteredUser(@RequestBody LoginDetails loginDetails) throws JsonProcessingException
	{
		return registeredCustomerService.checkLogin(loginDetails.getUserName() , loginDetails.getPassword());
	}
	
	@RequestMapping(value="/transfer",method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String transferMoney(JSONObject json) throws JSONException
	{
		return null;
	}
	
	@RequestMapping(value="/account/{id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String viewAccountDetails(@PathVariable long id) throws JsonProcessingException
	{
		return registeredCustomerService.viewAccountDetails(id);
	}
}
