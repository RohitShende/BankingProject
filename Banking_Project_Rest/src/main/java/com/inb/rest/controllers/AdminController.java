/**
 * 
 */
package com.inb.rest.controllers;

//import org.json.JSONObject;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		
		adminService.save(new Admin("Navin", "mahesh", "nm@gmail.com", 123, "abdress", new Date(), "nm", "nm"));
		return "Hello ADMIN";
	}

	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String registerUser(@RequestBody AdminPOJO adminPOJO) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		try {
			Admin admin = adminService.login(adminPOJO.getUsername(),
					adminPOJO.getPassword());
			String adminJson = mapper.writeValueAsString(admin);
			System.out.println("-->" + adminJson);
			return adminJson;
		} catch (NotAdminException e) {
			String errorJson = mapper.writeValueAsString(e.getMessage());
			return errorJson;
		}

	}
	
	

}
