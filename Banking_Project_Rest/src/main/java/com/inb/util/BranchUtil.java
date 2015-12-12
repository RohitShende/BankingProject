package com.inb.util;

import com.inb.mongo.collections.Branch;
import com.inb.mongo.collections.BranchManager;
import com.inb.rest.entity.BranchManagerPOJO;
import com.inb.rest.entity.BranchPOJO;

/**
 * @author islam_s
 *
 */

public class BranchUtil {

	public static BranchManager convertBranchManagerPojoToBranchManager(BranchManagerPOJO branchManagerPojo)
	{
		return new BranchManager(branchManagerPojo.getFirstName(), branchManagerPojo.getLastName(), branchManagerPojo.getEmail(), branchManagerPojo.getPhone(), branchManagerPojo.getAddress(), branchManagerPojo.getDateOfBirth(), branchManagerPojo.getUserName(), branchManagerPojo.getPassword());
	}
	
	public static Branch convertBranchPojoToBranch(BranchPOJO branchPojo)
	{
		return new Branch(branchPojo.getIfscCode(), 
				branchPojo.getBranchName(), 
				branchPojo.getAddress(),
				branchPojo.getContact());
	}
}
