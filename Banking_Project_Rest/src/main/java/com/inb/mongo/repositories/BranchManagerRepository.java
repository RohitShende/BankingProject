package com.inb.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inb.mongo.collections.BranchManager;

public interface BranchManagerRepository extends MongoRepository<BranchManager, String>{

}
