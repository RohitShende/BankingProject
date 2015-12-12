package com.inb.mongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.inb.mongo.collections.BranchManager;

public interface BranchManagerRepository extends MongoRepository<BranchManager, String>{
 
	@Query(value="{_id : ?0}")
	public List<BranchManager> findById(String id);
}
