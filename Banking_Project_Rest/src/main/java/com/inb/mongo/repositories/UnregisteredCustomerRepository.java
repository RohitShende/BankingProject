package com.inb.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inb.mongo.collections.UnregisteredCustomer;

public interface UnregisteredCustomerRepository extends MongoRepository<UnregisteredCustomer, String>{

}
