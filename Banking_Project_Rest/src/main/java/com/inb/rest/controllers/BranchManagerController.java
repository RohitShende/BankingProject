/**
 * 
 */
package com.inb.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inb.mongo.collections.Branch;
import com.inb.mongo.collections.BranchManager;
import com.inb.rest.entity.BranchManagerPOJO;
import com.inb.rest.entity.BranchPOJO;
import com.inb.rest.entity.LoginDetails;
import com.inb.service.impl.BranchManagerServiceImpl;
import com.inb.service.interfaces.BranchManagerService;

/**
 * @author jude_p
 *
 */
@RestController
public class BranchManagerController {
	
	@Autowired
	private BranchManagerService branchManagerService;
	
	@RequestMapping(value="/register", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody BranchManagerPOJO registerUser(@RequestBody BranchManagerPOJO branchManager) {
		
		
		BranchManager branchManagerObject=new BranchManager(branchManager.getFirstName(), branchManager.getLastName(), branchManager.getEmail(),
								branchManager.getPhone(), branchManager.getAddress(), branchManager.getDateOfBirth(), branchManager.getUsername(), 
								branchManager.getPassword());
		
		// branchManagerService.save()
		return branchManager;
	}
	
	@RequestMapping("/hellosss")
	public String sayHello(@RequestParam(value="name", defaultValue="Ivan") String name) {
		return "Hellosss " + name;
	}
	
	@RequestMapping(value="/loginBranchManager", method=RequestMethod.POST)
	public boolean loginBranchManager(@ModelAttribute LoginDetails loginDetails) {
		System.out.println("Inside loginBranchManager   "+loginDetails.getUsername());
		return branchManagerService.login(loginDetails.getUsername(), loginDetails.getPassword());
	}
	
	public BranchManager convertBranchManagerPojoToBranchManager(BranchManagerPOJO branchManagerPojo)
	{
		return new BranchManager(branchManagerPojo.getFirstName(), branchManagerPojo.getLastName(), branchManagerPojo.getEmail(), branchManagerPojo.getPhone(), branchManagerPojo.getAddress(), branchManagerPojo.getDateOfBirth(), branchManagerPojo.getUsername(), branchManagerPojo.getPassword());
	}
	
	public Branch convertBranchPojoToBranch(BranchPOJO branchPojo)
	{
		return new Branch(branchPojo.getIfscCode(), 
				branchPojo.getBranchName(), 
				branchPojo.getAddress(),
				branchPojo.getContact(),
				convertBranchManagerPojoToBranchManager(branchPojo.getBranchManager()));
	}
	
}
