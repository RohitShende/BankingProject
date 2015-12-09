package com.inb.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inb.exceptions.BranchManagerExistsException;
import com.inb.exceptions.NotBranchManagerException;
import com.inb.mongo.collections.BranchManager;
import com.inb.mongo.repositories.BranchManagerRepository;
import com.inb.service.interfaces.BranchManagerService;

@Service
public class BranchManagerServiceImpl implements BranchManagerService {

	ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private BranchManagerRepository branchManagerRepository;
	
	@Autowired
	private MongoOperations mongoOperations;
	
	public BranchManager insert(BranchManager branchManager) throws BranchManagerExistsException  {
		
		BasicQuery basicQuery= new BasicQuery("{ \"username\":\""+branchManager.getUsername()+"\",\"email\":\""+branchManager.getEmail()+"\" }");
		BranchManager tempBranchManager= mongoOperations.findOne(basicQuery,BranchManager.class);
	
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
	
	
	public String insertBranchManager(BranchManager branchManager) throws JsonProcessingException
	{
		try {
			BranchManager branchManagerDetails=insert(branchManager);
			String branchManagerJson = mapper.writeValueAsString(branchManagerDetails);
			return branchManagerJson;
			}catch(BranchManagerExistsException e)
			{
				String str =  "{ \"Exception\" : \"BranchManagerExistsException\" }";
				return str;
			}
	}
	
	
	public String login(String username, String password) throws JsonProcessingException {
		String branchManagerJson;
		try {
				BasicQuery basicQuery= new BasicQuery("{ username : \""+username+"\" , password : \""+password+"\" }");
				BranchManager branchManager= mongoOperations.findOne(basicQuery,BranchManager.class);
				if(branchManager!=null)
				{
					branchManagerJson = mapper.writeValueAsString(branchManager);
				}
				else
				{
					throw new NotBranchManagerException(username);
				}
			}catch(NotBranchManagerException e)
			{
				branchManagerJson=e.toString();
			}
		return branchManagerJson;
	}
	
}
