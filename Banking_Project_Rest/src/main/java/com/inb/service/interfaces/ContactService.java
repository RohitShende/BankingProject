package com.inb.service.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inb.mongo.collections.Contact;

public interface ContactService {

	String insert(Contact contact) throws JsonProcessingException;
}
