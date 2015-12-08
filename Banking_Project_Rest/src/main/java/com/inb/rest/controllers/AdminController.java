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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inb.exceptions.NotAdminException;
import com.inb.mongo.collections.Admin;
import com.inb.rest.entity.AdminPOJO;
import com.inb.service.interfaces.AdminService;

/**
 * @author Navin Maheshwari
 *
 */
@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "Hello ADMIN";
	}

	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String registerUser(@RequestBody AdminPOJO adminPOJO)
			throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println("REQUEST RECIVEd..");
			Admin admin = adminService.login(adminPOJO.getUsername(),
					adminPOJO.getPassword());
			String adminJson = mapper.writeValueAsString(admin);
			return adminJson;
		} catch (NotAdminException e) {
			//String errorJson = mapper.writeValueAsString(e.getMessage());
			String str =  "{ \"error\" :" + e.getMessage() + "}";
			
			return str;
		}

	}

}
