package com.inb.rest.controllers;

import java.io.IOException;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.inb.rest.entity.UnregisteredCustomerPOJO;
import com.inb.service.interfaces.UnregisteredCustomerService;

@CrossOrigin
@RestController
@RequestMapping(value = "/unregistereduser")
public class UnregisteredCustomerController {

	@Autowired
	private UnregisteredCustomerService unregisteredCustomerService;

	/*--------------Register User Application--------------*/
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String registerEnquiry(@RequestBody UnregisteredCustomerPOJO unregisteredCustomerPOJO) {

		return unregisteredCustomerService
				.registerEnquiry(unregisteredCustomerPOJO);
	}

	/*--------------Check for Already Registered Email--------------*/
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getCustomersByEmail(@QueryParam("email") String email) {

		return unregisteredCustomerService.isEmailAlreadyExits(email);
	}

	/*--------------Verify Unregistered Users--------------*/
	@RequestMapping(value = "/details", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getUnregisteredUsers() throws JsonProcessingException {
		return unregisteredCustomerService.verifyUnregisteredUsers();
	}

	/*--------------View Details of Rejected Application--------------*/
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String viewUnregisteredUserDetails(
			@PathVariable String id) throws JsonProcessingException {
		return unregisteredCustomerService.viewUnregisteredUserDetails(id);
	}

	/*--------------Sending Registration Email--------------*/
	@RequestMapping(value="/email/{id}/{status}", method=RequestMethod.PUT,produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String sendRegistrationEmail(@PathVariable String id,@PathVariable String status) throws JsonParseException, JsonMappingException, IOException, ClassNotFoundException
	{
		return unregisteredCustomerService.sendEmail(id,status);
		
	}
}
