package com.inb.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Service;

import com.inb.exceptions.BranchManagerExistsException;
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
	
	public BranchManager insert(BranchManager branchManager) throws BranchManagerExistsException  {
		
		BasicQuery basicQuery= new BasicQuery("{ \"username\":\""+branchManager.getUsername()+"\",\"email\":\""+branchManager.getEmail()+"\" }");
		BranchManager tempBranchManager= mongoOperations.findOne(basicQuery,BranchManager.class);
		System.out.println("-------------" + tempBranchManager);
		boolean flag=false;
		if(tempBranchManager==null&&branchManager.getFirstName()!=null)
		{
			branchManager=branchManagerRepository.insert(branchManager);
			flag=true;
		}
		if(!flag)
		{
			throw new BranchManagerExistsException();
		}
		return branchManager;
	}
	
	
	public BranchManager login(String username, String password) throws NotBranchManagerException {
		
		BasicQuery basicQuery= new BasicQuery("{ username : \""+username+"\" }");
		BranchManager branchManager= mongoOperations.findOne(basicQuery,BranchManager.class);
		boolean flag=false;
		if(branchManager!=null)
		{
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
