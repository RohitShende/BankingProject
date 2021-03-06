package com.inb.mongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.inb.mongo.collections.RegisteredCustomer;

public interface RegisteredCustomerRepository extends
		MongoRepository<RegisteredCustomer, String> {
	@Query(value = "{customerId : ?0}")
	public List<RegisteredCustomer> findBycustomerId(long id);
	
	@Query(value="{_id : ?0}")
	public List<RegisteredCustomer> findById(String id);
	
	@Query(value="{email: ?0}")
	public List<RegisteredCustomer> findByEmail(String email);
	
	@Query(value = "{accounthash.accountNumber : ?0}")
	public List<RegisteredCustomer> findByAccountNumber(long accountNumber);

}
