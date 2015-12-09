/**
 * 
 */
package com.inb.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inb.exceptions.NotAdminException;
import com.inb.mongo.collections.Admin;
import com.inb.mongo.repositories.AdminRepository;
import com.inb.rest.entity.AdminPOJO;
import com.inb.service.impl.AdminServiceImpl;
import com.inb.service.interfaces.AdminService;
import com.inb.util.AdminUtil;

/**
 * @author Navin Maheshwari
 *
 */
@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String loginAdmin(@RequestBody AdminPOJO adminPOJO,
			@RequestParam String id) throws JsonProcessingException {
		return adminService.login(adminPOJO.getUsername(),
				adminPOJO.getPassword());
	}
}
