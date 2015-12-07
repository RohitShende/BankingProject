package com.inb.services.impl;

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

}
