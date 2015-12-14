package com.inb.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inb.mongo.collections.RegisteredCustomer;

public interface RegisteredCustomerRepository extends
		MongoRepository<RegisteredCustomer, String> {
	
	
}
