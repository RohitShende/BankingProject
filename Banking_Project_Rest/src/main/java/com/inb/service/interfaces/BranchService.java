package com.inb.service.interfaces;

import com.inb.exceptions.BranchAlreadyExistException;
import com.inb.mongo.collections.Branch;

public interface BranchService {
	
	Branch insert(Branch branch) throws BranchAlreadyExistException;

}
