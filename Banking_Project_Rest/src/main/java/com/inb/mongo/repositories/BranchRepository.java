package com.inb.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inb.mongo.collections.Branch;

public interface BranchRepository extends MongoRepository<Branch, String>{

}
