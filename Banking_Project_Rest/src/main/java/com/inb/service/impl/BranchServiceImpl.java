package com.inb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inb.exceptions.BranchAlreadyExistException;
import com.inb.mongo.collections.Branch;
import com.inb.mongo.repositories.BranchRepository;
import com.inb.service.interfaces.BranchService;

@Service
public class BranchServiceImpl implements BranchService{

	@Autowired
	private MongoOperations mongoOperations;

	@Autowired
	private BranchRepository branchRepository;
	
	ObjectMapper mapper = new ObjectMapper();

	
	public String insert(Branch branch) throws JsonProcessingException {
		String branchJson;
		try{
			BasicQuery basicQuery= new BasicQuery("{ ifscCode : \""+branch.getIfscCode()+"\" }");
			Branch branchResult= mongoOperations.findOne(basicQuery,Branch.class);
			if(branchResult==null)
			{
				branchRepository.insert(branch);
				branchJson = mapper.writeValueAsString(branch);
			}
			else
			{
				throw new BranchAlreadyExistException();
			}
		}
		catch(BranchAlreadyExistException e)
		{
			branchJson=e.toString();
		}
		return branchJson;
	}

}
