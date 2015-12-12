package com.inb.service.interfaces;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.inb.exceptions.BranchManagerExistsException;
import com.inb.exceptions.InvalidInputException;
import com.inb.mongo.collections.BranchManager;

public interface BranchManagerService {
	BranchManager insert(BranchManager branchManager) throws BranchManagerExistsException,InvalidInputException;
	String login(String username, String password)throws JsonProcessingException;
	String insertBranchManager(BranchManager branchManager) throws JsonProcessingException;
	
	String verifyUnregisteredUsers() throws JsonProcessingException ;
	String sendEmail(String id) throws JsonParseException, JsonMappingException, IOException;
}
