package com.inb.service.interfaces;

import com.inb.mongo.collections.Documents;

public interface DocumentService {

	public String uploadDocument(Documents documents);
	public Documents retriveDocumentForClientId(String id);
}
