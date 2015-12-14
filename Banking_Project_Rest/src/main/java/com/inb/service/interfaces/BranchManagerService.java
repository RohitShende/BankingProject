package com.inb.service.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inb.exceptions.BranchManagerExistsException;
import com.inb.exceptions.InvalidInputException;
import com.inb.mongo.collections.BranchManager;

public interface BranchManagerService {
	BranchManager insert(BranchManager branchManager) throws BranchManagerExistsException,InvalidInputException;
	String login(String username, String password)throws JsonProcessingException;
	String insertBranchManager(BranchManager branchManager) throws JsonProcessingException;
	
//	String verifyUnregisteredUsers() throws JsonProcessingException ;
//	String sendEmail(String id) throws JsonParseException, JsonMappingException, IOException;
	
	String viewBranchManagers() throws JsonProcessingException ;
	String logout(String userName) throws JsonProcessingException;
}
