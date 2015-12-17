package com.inb.mongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.inb.mongo.collections.Branch;
import com.inb.mongo.collections.RegisteredCustomer;

public interface BranchRepository extends MongoRepository<Branch, String>{
	
	@Query(value = "{branchName : ?0}")
	public List<Branch> findByBranchName(String branchName);
}
