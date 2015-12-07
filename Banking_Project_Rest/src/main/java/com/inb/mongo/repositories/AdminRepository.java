package com.inb.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inb.mongo.collections.Admin;

public interface AdminRepository extends MongoRepository<Admin, String>{

}
