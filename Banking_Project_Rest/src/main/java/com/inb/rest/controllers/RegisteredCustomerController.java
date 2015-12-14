/**
 * 
 */
package com.inb.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inb.rest.entity.RegisteredCustomerPOJO;
import com.inb.service.interfaces.RegisteredCustomerService;

/**
 * @author shende_r
 *
 */
@CrossOrigin
@RestController
public class RegisteredCustomerController {

	@Autowired
	private RegisteredCustomerService registeredCustomerService;

	@RequestMapping(value = "/newaccount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String registerEnquiry(
			@RequestBody RegisteredCustomerPOJO registeredCustomerPOJO) {
		registeredCustomerPOJO.getCustomerId();
		return registeredCustomerService
				.registerEnquiry(registeredCustomerPOJO);
	}

}
