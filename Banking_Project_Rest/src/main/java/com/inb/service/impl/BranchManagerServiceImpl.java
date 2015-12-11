package com.inb.service.impl;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inb.exceptions.BranchManagerExistsException;
import com.inb.exceptions.InvalidInputException;
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
	
	public BranchManager insert(BranchManager branchManager) throws BranchManagerExistsException, InvalidInputException  {
		
		//BasicQuery basicQuery= new BasicQuery("{ \"username\":\""+branchManager.getUsername()+"\",\"email\":\""+branchManager.getEmail()+"\" }");
		
		BasicQuery basicQuery= 
				new BasicQuery("{ $or: [ { \"userName\": \""+branchManager.getUserName()+"\" }, { \"email\": \""+branchManager.getEmail()+"\" } ] }");
		BranchManager tempBranchManager= mongoOperations.findOne(basicQuery,BranchManager.class);
	
		Date currentDate=new Date();
		Date enteredDate=branchManager.getDateOfBirth();
		int comparison = currentDate.compareTo(enteredDate);
		
		
		int flag=0;
		
		if(comparison==-1)
		{
			flag=1;
		}
		if(tempBranchManager==null&&branchManager.getFirstName()!=null&&comparison!=-1)
		{
			
			branchManager=branchManagerRepository.insert(branchManager);
			flag=2;
		}
		if(flag==1)
		{
			throw new InvalidInputException();
		}
		if(flag==0)
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
				String str = "{ \"Exception\": \""+ e.getMessage() + "\"}";
				return str;
			} catch (InvalidInputException e) {
				String str = "{ \"Exception\": \""+ e.getMessage() + "\"}";
				return str;
			}
	}
	
	
	public String login(String userName, String password) throws JsonProcessingException {
		String branchManagerJson;
		try {
				BasicQuery basicQuery= new BasicQuery("{ userName : \""+userName+"\" , password : \""+password+"\" }");
				BranchManager branchManager= mongoOperations.findOne(basicQuery,BranchManager.class);
				if(branchManager!=null)
				{
					branchManagerJson = mapper.writeValueAsString(branchManager);
				}
				else
				{
					throw new NotBranchManagerException(userName);
				}
			}catch(NotBranchManagerException e)
			{
				branchManagerJson=e.toString();
			}
		return branchManagerJson;
	}
	
}
