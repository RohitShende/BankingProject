package com.inb.service.interfaces;

import com.inb.mongo.collections.BranchManager;

public interface BranchManagerService {
	String save(BranchManager branchManager);
	boolean login(String username, String password);
}
