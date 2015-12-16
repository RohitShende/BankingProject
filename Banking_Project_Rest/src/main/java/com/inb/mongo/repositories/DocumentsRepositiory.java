package com.inb.mongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.inb.mongo.collections.Documents;

public interface DocumentsRepositiory extends MongoRepository<Documents, String> {
	
	@Query(value="{userId : ?0}")
	public List<Documents> findByUserId(String Id);
	
}
