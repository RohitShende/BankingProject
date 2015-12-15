package com.inb.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inb.mongo.collections.Documents;
import com.inb.service.interfaces.DocumentService;
import com.inb.service.interfaces.UnregisteredCustomerService;



@CrossOrigin
@RestController
public class UploadDocumemtsController {

	@Autowired
	private UnregisteredCustomerService unregisteredCustomerService;
	@Autowired
	private DocumentService documentService;

	
	@RequestMapping(value = "/document", method = RequestMethod.POST, headers = ("content-type=multipart/*"), produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String uploadDocuments(
			@RequestParam("addressProof") MultipartFile addressProof,
			@RequestParam("ageProof") MultipartFile ageProof,
			@RequestParam("id") String id) {
		if (!ageProof.isEmpty() && !addressProof.isEmpty()) {
			System.out.println("-->in upload");
			try {
				Documents documents = new Documents();
				documents.setAddressProof(addressProof.getBytes());
				documents.setAgeProof(ageProof.getBytes());
				documents.setUserId(id);
				System.out.println("retriving..");
				//documentService.retriveDocumentForClientId("032132");
				System.out.println("retriving done..");
				documentService.uploadDocument(documents);
				return "{\"Message\":\"SucessTRY\"}";
			} catch (Exception e) {
				e.printStackTrace();
				return "{\"Message\":\"Exception@server\"}";
			}
		} else {
			return "{\"Message\":\"File Empty\"}";
		}
	}
	
	
	@RequestMapping(value="/addressproofdocument/{id}",method=RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String retrieveAddressProofDocuments(@PathVariable String id) throws JsonProcessingException
	{
		return documentService.retriveAddressProofDocumentForClientId(id);
	}
	
	@RequestMapping(value="/ageproofdocument/{id}",method=RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String retrieveDocuments(@PathVariable String id) throws JsonProcessingException
	{

		return documentService.retriveAgeProofDocumentForClientId(id);
	}
}
