package com.inb.mongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.inb.mongo.collections.Person;
import com.inb.mongo.collections.UnregisteredCustomer;
import com.inb.rest.entity.Account;

public interface UnregisteredCustomerRepository extends
		MongoRepository<Person, String> {
	
	@Query(value="{account : ?0}")
	public List<UnregisteredCustomer> getUserByAccount(Account account);
	
	@Query(value="{email : ?0}")
	public List<Person> getUserByEmail(String email);
	
	@Query(value="{_id : ?0}")
	public List<Person> findById(String id);
}
