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

import com.inb.mongo.collections.Branch;
import com.inb.mongo.collections.BranchManager;
import com.inb.rest.entity.BranchManagerPOJO;
import com.inb.rest.entity.BranchPOJO;
import com.inb.service.interfaces.BranchService;

/**
 * @author islam_s
 *
 */
@RestController
public class BranchController {

	@Autowired
	private BranchService branchService;
	
	@RequestMapping(value="/createBranch", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Branch createBranch(@RequestBody BranchPOJO createBranchPOJO)
	{
		branchService.save(convertBranchPojoToBranch(createBranchPOJO));
		return convertBranchPojoToBranch(createBranchPOJO);

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
