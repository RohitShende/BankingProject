package com.inb.service.impl;

import java.util.List;

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


	/*public List<Branch> getAllBranchs() {
		List<Branch> branch = new ArrayList<Branch>();
		branch.add(new Branch("456","xyz", "indore",9875));
		branch.add(new Branch("123","abc", "pune",12345));
		return branch;
		
	}*/
	
	public String viewBranchRange(int start,int end) throws JsonProcessingException
	{
		BasicQuery basicQuery= new BasicQuery("{}");
		basicQuery.skip(start);
		basicQuery.limit(end);
		List<Branch> listOfBranches = mongoOperations.find(basicQuery, Branch.class);
		
		String result=mapper.writeValueAsString(listOfBranches);	
		System.out.println(result);
		return result;
		
	}

	public String viewBranches() throws JsonProcessingException {
//		String branchJson="No Branches";
		
		String branchJson = "{ \"Error\": \"No Branches\"}";
		List<Branch> listOfBranches=branchRepository.findAll();
		
		if(listOfBranches!=null)
		{
			if(listOfBranches.size()!=0)
				branchJson=mapper.writeValueAsString(listOfBranches);
		}
		return branchJson;
	}
}
