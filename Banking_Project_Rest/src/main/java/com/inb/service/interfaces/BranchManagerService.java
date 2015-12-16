package com.inb.service.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inb.exceptions.BranchManagerExistsException;
import com.inb.exceptions.InvalidInputException;
import com.inb.mongo.collections.BranchManager;

public interface BranchManagerService {
	BranchManager insert(BranchManager branchManager) throws BranchManagerExistsException,InvalidInputException;
	String login(String username, String password)throws JsonProcessingException;
	String insertBranchManager(BranchManager branchManager) throws JsonProcessingException;
	String viewBranchManagers() throws JsonProcessingException ;
	String viewBranchManagersRange(int start,int end) throws JsonProcessingException;
	String logout(String role, String id);
}
