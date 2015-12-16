package com.inb.service.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inb.mongo.collections.Branch;

public interface BranchService {
	
	String insert(Branch branch) throws JsonProcessingException;
	String viewBranches() throws JsonProcessingException;
	String viewBranchRange(int start,int end) throws JsonProcessingException;

}
