package com.inb.service.interfaces;

import com.inb.mongo.collections.BranchManager;

public interface BranchManagerService {
	void save(BranchManager branchManager);
	boolean login();
	boolean logout();
}
