package com.inb.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inb.service.interfaces.RegisteredCustomerService;

@CrossOrigin
@RestController
@RequestMapping(value="/authorisation")
public class CustomerAuthorisationController {

	@Autowired
	private RegisteredCustomerService registeredCustomerService;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAuthoriseDetailsCustomerById(
			@PathVariable String id) {
		return registeredCustomerService.getAuthorisationDataClientId(id);
		
	}

}
