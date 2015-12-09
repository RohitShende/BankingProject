package com.inb.service.interfaces;

import com.inb.exceptions.NotBranchManagerException;
import com.inb.mongo.collections.BranchManager;

public interface BranchManagerService {
	String insert(BranchManager branchManager);
	BranchManager login(String username, String password) throws NotBranchManagerException;
	
}
