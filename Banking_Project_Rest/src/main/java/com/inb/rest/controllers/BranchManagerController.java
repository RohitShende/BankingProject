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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inb.rest.entity.BranchManagerPOJO;
import com.inb.rest.entity.LoginDetails;
import com.inb.rest.entity.LogoutDetails;
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
	
	/*--------------Create Branch Manager by Admin--------------*/
	@RequestMapping(value="/", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createBranchManager(@RequestBody BranchManagerPOJO branchManager) throws JsonProcessingException {
			
			String result=branchManagerService.insertBranchManager(branchManager);
			return result;
	}
	
	/*--------------Login by Branch Manager--------------*/
	@RequestMapping(value="/login", method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String loginBranchManager(@RequestBody LoginDetails loginDetails) throws JsonProcessingException{
		return branchManagerService.login(loginDetails.getUserName(), loginDetails.getPassword());
	}
	
	/*--------------Logout by Branch Manager--------------*/
	@RequestMapping(value="/logout", method=RequestMethod.PUT, produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String logoutBranchManager(@RequestBody LogoutDetails logoutDetails){
		return branchManagerService.logout(logoutDetails.getRole(),logoutDetails.getId());
	}
	
	/*--------------View Branch Managers by Admin--------------*/
	@RequestMapping(value="/", method=RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String viewBranchManagers() throws JsonProcessingException
	{
		return branchManagerService.viewBranchManagers();
	}
	
	/*--------------View Branch Managers within Range by Admin--------------*/
	@RequestMapping(value = "/{start}/{end}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String viewBranchManagersRange(@PathVariable("start") int start, @PathVariable("end") int end) throws JsonProcessingException {

		return branchManagerService.viewBranchManagersRange(start, end);
	}
	
	
}
