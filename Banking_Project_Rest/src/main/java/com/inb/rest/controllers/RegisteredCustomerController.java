/**
 * 
 */
package com.inb.rest.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inb.rest.entity.RegisteredCustomerPOJO;

/**
 * @author shende_r
 *
 */
@RestController
public class RegisteredCustomerController {

	@RequestMapping(value = "/newaccount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String registerEnquiry(
			@RequestBody RegisteredCustomerPOJO registeredCustomerPOJO) {
		return null;
	}
	
}
