package com.inb.service.interfaces;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inb.mongo.collections.Branch;

public interface BranchService {
	
	String insert(Branch branch) throws JsonProcessingException;
	List<Branch> getAllBranchs();

}
