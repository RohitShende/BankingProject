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
import com.inb.rest.entity.BranchPOJO;
import com.inb.service.interfaces.BranchService;
import com.inb.util.BranchUtil;

/**
 * @author islam_s
 *
 */
@CrossOrigin
@RestController
public class BranchController {

		
	@Autowired
	private BranchService branchService;
	
	@RequestMapping(value="/createBranch", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createBranch(@RequestBody BranchPOJO branchPOJO) throws JsonProcessingException
	{
		
		return branchService.insert(BranchUtil.convertBranchPojoToBranch(branchPOJO));

	}
	
	@RequestMapping(value="/viewBranches", method=RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String viewBranches() throws JsonProcessingException
	{
		return branchService.viewBranches();
	}
}
