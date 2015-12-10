package com.inb.mongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.inb.mongo.collections.Admin;

public interface AdminRepository extends MongoRepository<Admin, String>{

	@Query(value="{userName: ?0,password: ?1}")
	public List<Admin> findByUsernameAndPassword(String userName, String password);
	
	
	@Query(value="{_id: ?0}")
	public List<Admin> findById( String id);
}
