package com.inb.service.impl;


import java.util.Date;
import java.util.List;

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
import com.inb.util.DateConversionUtil;

@Service
public class BranchManagerServiceImpl implements BranchManagerService {

	ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private BranchManagerRepository branchManagerRepository;
	
	@Autowired
	private MongoOperations mongoOperations;

	
	public BranchManager insert(BranchManager branchManager) throws BranchManagerExistsException, InvalidInputException  {
		
		
		
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
	
		Date isoDate=DateConversionUtil.changeDateFormat(branchManager);
		branchManager.setDateOfBirth(isoDate);
		
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
					branchManager.setLogin(true);
					mongoOperations.save(branchManager);
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


	public String viewBranchManagers() throws JsonProcessingException {

		
		String branchManagerJson = "{ \"Error\": \"No Branch Managers\"}";
		List<BranchManager> listOfBrancheManagers=branchManagerRepository.findAll();
		
		if(listOfBrancheManagers!=null)
		{
		
			if(listOfBrancheManagers.size()!=0)
				branchManagerJson=mapper.writeValueAsString(listOfBrancheManagers);
		}
		return branchManagerJson;
	}

	public String viewBranchManagersRange(int start,int end) throws JsonProcessingException
	{
		BasicQuery basicQuery= new BasicQuery("{}");
		basicQuery.skip(start);
		basicQuery.limit(end);
		List<BranchManager> listOfBranchManagers = mongoOperations.find(basicQuery, BranchManager.class);
		
		String result=mapper.writeValueAsString(listOfBranchManagers);	
		System.out.println(result);
		return result;
		
	}
	
	public String logout(String userName) throws JsonProcessingException {
		String branchManagerJson;
		try {
				BasicQuery basicQuery= new BasicQuery("{\"userName\":\""+userName+"\"}");
				BranchManager branchManager= mongoOperations.findOne(basicQuery,BranchManager.class);
				if(branchManager!=null)
				{
					branchManager.setLogin(false);
					mongoOperations.save(branchManager);
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
