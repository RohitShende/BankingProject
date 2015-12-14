package com.inb.mongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.inb.mongo.collections.Admin;
import com.inb.mongo.collections.BranchManager;
import com.inb.mongo.collections.UnregisteredCustomer;
import com.inb.rest.entity.Account;

public interface UnregisteredCustomerRepository extends
		MongoRepository<UnregisteredCustomer, String> {
	
	@Query(value="{account : ?0}")
	public List<Admin> getUserByAccount(Account account);
	
	@Query(value="{_id : ?0}")
	public List<BranchManager> findById(String id);
}
