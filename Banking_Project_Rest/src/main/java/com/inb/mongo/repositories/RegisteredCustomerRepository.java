package com.inb.mongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.inb.mongo.collections.RegisteredCustomer;
import com.inb.mongo.collections.UnregisteredCustomer;

public interface RegisteredCustomerRepository extends
		MongoRepository<RegisteredCustomer, String> {
	@Query(value = "{customerId : ?0}")
	public List<UnregisteredCustomer> findBycustomerId(long id);
	
	@Query(value="{_id : ?0}")
	public List<RegisteredCustomer> findById(String id);

}
