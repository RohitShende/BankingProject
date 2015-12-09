package com.inb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Service;

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
	
	public Branch insert(Branch branch) throws BranchAlreadyExistException{
	//	branchRepository.insert(branch);
		BasicQuery basicQuery= new BasicQuery("{ ifscCode : \""+branch.getIfscCode()+"\" }");
		System.out.println(basicQuery);
		Branch branchResult= mongoOperations.findOne(basicQuery,Branch.class);
		System.out.println(branchResult);
		if(branchResult==null)
		{
			branchRepository.insert(branch);
			return branch;

		}
		else
		{
			throw new BranchAlreadyExistException();
		}
	}

}
