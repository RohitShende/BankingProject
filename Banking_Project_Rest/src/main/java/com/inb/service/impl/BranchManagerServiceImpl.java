package com.inb.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Service;

import com.inb.exceptions.NotBranchManagerException;
import com.inb.mongo.collections.BranchManager;
import com.inb.mongo.repositories.BranchManagerRepository;
import com.inb.service.interfaces.BranchManagerService;

@Service
public class BranchManagerServiceImpl implements BranchManagerService {

	@Autowired
	private BranchManagerRepository branchManagerRepository;
	
	@Autowired
	private MongoOperations mongoOperations;
	
	public String insert(BranchManager branchManager)  {
		branchManagerRepository.insert(branchManager);
		return "Branch Manager Added";
	}

	public BranchManager login(String username, String password) throws NotBranchManagerException {
		
		System.out.println("From Form..."+username+"...."+password);
		BasicQuery basicQuery= new BasicQuery("{ username : \""+username+"\" }");
		BranchManager branchManager= mongoOperations.findOne(basicQuery,BranchManager.class);
		System.out.println("Branch manager object : "+branchManager);
		boolean flag=false;
		if(branchManager!=null)
		{
			System.out.println("Inside BranchManagerImpl.. FirstName= "+branchManager.getFirstName());
			if(branchManager.getUsername().equals(username) && 
						branchManager.getPassword().equals(password))
			{
				flag=true;
			}
		}
		if(!flag)
		{
			throw new NotBranchManagerException();
		}
		return branchManager;
	}

	
}
