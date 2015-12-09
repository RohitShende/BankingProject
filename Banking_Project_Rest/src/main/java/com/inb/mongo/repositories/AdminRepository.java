package com.inb.mongo.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.inb.mongo.collections.Admin;

public interface AdminRepository extends MongoRepository<Admin, String>{

	@Query(value="{username: ?0,password: ?1}")
	public List<Admin> findByUsernameAndPassword(String username, String password);
	
	
	@Query(value="{_id: ?0}")
	public List<Admin> findById( String id);
}
