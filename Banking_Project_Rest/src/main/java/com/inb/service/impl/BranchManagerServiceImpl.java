package com.inb.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inb.mongo.collections.BranchManager;
import com.inb.mongo.repositories.BranchManagerRepository;
import com.inb.service.interfaces.BranchManagerService;

@Service
public class BranchManagerServiceImpl implements BranchManagerService {

	@Autowired
	private BranchManagerRepository branchManagerRepository;
	
	public void save(BranchManager branchManager) {
		branchManagerRepository.save(branchManager);
		
	}

	public boolean login(String username, String password) {
		System.out.println("From Form..."+username+"...."+password);
		
		/*if(username.equals("Rohit") && password.equals("Rohit123#"))
			return true; */
		return false;
	}

	
}
