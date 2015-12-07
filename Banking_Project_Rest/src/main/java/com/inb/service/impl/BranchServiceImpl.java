package com.inb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inb.mongo.collections.Branch;
import com.inb.mongo.repositories.BranchRepository;
import com.inb.service.interfaces.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchRepository branchRepository;
	
	public void save(Branch branch) {
		branchRepository.save(branch);
	}

}
