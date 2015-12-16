package com.inb.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inb.mongo.collections.Contact;

public interface ContactRepository extends MongoRepository<Contact, String>{


}
