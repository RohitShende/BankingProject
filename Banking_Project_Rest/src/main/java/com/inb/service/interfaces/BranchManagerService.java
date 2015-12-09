package com.inb.service.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inb.exceptions.BranchManagerExistsException;
import com.inb.exceptions.NotBranchManagerException;
import com.inb.mongo.collections.BranchManager;

public interface BranchManagerService {
	BranchManager insert(BranchManager branchManager) throws BranchManagerExistsException;
	BranchManager login(String username, String password) throws NotBranchManagerException;
	String insertBranchManager(BranchManager branchManager) throws JsonProcessingException;
}
