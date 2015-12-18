package com.inb.service.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inb.exceptions.BranchManagerExistsException;
import com.inb.exceptions.InvalidInputException;
import com.inb.mongo.collections.BranchManager;
import com.inb.rest.entity.BranchManagerPOJO;

public interface BranchManagerService {
	BranchManager insert(BranchManager branchManager) throws BranchManagerExistsException,InvalidInputException;
	String login(String username, String password, String branchName)throws JsonProcessingException;
	String insertBranchManager(BranchManagerPOJO branchManager) throws JsonProcessingException;
	String viewBranchManagers() throws JsonProcessingException ;
	String viewBranchManagersRange(int start,int end) throws JsonProcessingException;
	String logout(String role, String id);
}
