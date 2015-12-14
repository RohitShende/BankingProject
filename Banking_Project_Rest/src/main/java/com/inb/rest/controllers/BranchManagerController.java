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
import com.inb.mongo.collections.BranchManager;
import com.inb.rest.entity.BranchManagerPOJO;
import com.inb.rest.entity.LoginDetails;
import com.inb.service.interfaces.BranchManagerService;

/**
 * @author jude_p
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value="/branchmanager")
public class BranchManagerController {
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private BranchManagerService branchManagerService;
	
	@RequestMapping(value="/", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createBranchManager(@RequestBody BranchManagerPOJO branchManager) throws JsonProcessingException {
			
			String result=branchManagerService.insertBranchManager(new BranchManager(branchManager.getFirstName(), branchManager.getLastName(), branchManager.getEmail(),
					branchManager.getPhone(), branchManager.getAddress(), branchManager.getDateOfBirth(), branchManager.getUserName(), 
					branchManager.getPassword()));
			
			return result;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String loginBranchManager(@RequestBody LoginDetails loginDetails) throws JsonProcessingException{
		return branchManagerService.login(loginDetails.getUserName(), loginDetails.getPassword());
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String viewBranchManagers() throws JsonProcessingException
	{
		return branchManagerService.viewBranchManagers();
	}
	
//	@RequestMapping(value="/verifyUnregisteredUsers", method=RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody String verifyUnregisteredUsers() throws JsonProcessingException
//	{
//		return branchManagerService.verifyUnregisteredUsers();
//	}
	
//	@RequestMapping(value="/sendRegistrationEmail", method=RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE,consumes= MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody String sendRegistrationEmail(@RequestBody String id) throws JsonParseException, JsonMappingException, IOException
//	{
//		System.out.println(id);
//		branchManagerService.sendEmail(id);
//		return id;
//	}
	
}
