/**
 * 
 */
package com.inb.rest.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inb.mongo.collections.BranchManager;
import com.inb.rest.entity.BranchManagerPOJO;
import com.inb.rest.entity.LoginDetails;
import com.inb.service.interfaces.BranchManagerService;

/**
 * @author jude_p
 *
 */
@RestController
public class BranchManagerController {
	
	@Autowired
	private BranchManagerService branchManagerService;
	
	@RequestMapping(value="/addBranchManager", method=RequestMethod.POST)
	public boolean createBranchManager(@ModelAttribute BranchManagerPOJO branchManager) {
		
		System.out.println("BranchManager*******"+branchManager.getDateOfBirth());
		System.out.println(branchManager.getDateOfBirth().getDate());
		
		Date isoDate=new Date(branchManager.getDateOfBirth().getYear(), branchManager.getDateOfBirth().getMonth(), branchManager.getDateOfBirth().getDate()+1);
		//System.out.println(isoDate);
		branchManagerService.save(new BranchManager(branchManager.getFirstName(), branchManager.getLastName(), branchManager.getEmail(),
				branchManager.getPhone(), branchManager.getAddress(), isoDate, branchManager.getUsername(), 
				branchManager.getPassword())); 
		return true;

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
	
}
