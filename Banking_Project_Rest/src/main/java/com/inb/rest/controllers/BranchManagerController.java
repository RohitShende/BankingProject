/**
 * 
 */
package com.inb.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inb.mongo.collections.BranchManager;
import com.inb.rest.entity.BranchManagerPOJO;
import com.inb.service.interfaces.BranchManagerService;

/**
 * @author jude_p
 *
 */
@RestController
public class BranchManagerController {
	
	@Autowired
	private BranchManagerService branchManagerService;
	
//	@RequestMapping(value="/register", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody BranchManagerPOJO registerUser(@RequestBody BranchManagerPOJO branchManager) {
//		branchManagerService.save(new BranchManager(branchManager.getFirstName(), branchManager.getLastName(), branchManager.getEmail(), branchManager.getPhone(), 
//				branchManager.getAddress(), branchManager.getDateOfBirth(), branchManager.getUsername(), branchManager.getPassword(), branchManager.getBranch())
//		return branchManager;
//	}
}
