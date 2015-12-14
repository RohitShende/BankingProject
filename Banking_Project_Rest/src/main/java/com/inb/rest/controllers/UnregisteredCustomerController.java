package com.inb.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inb.mongo.collections.Documents;
import com.inb.rest.entity.UnregisteredCustomerPOJO;
import com.inb.service.interfaces.DocumentService;
import com.inb.service.interfaces.UnregisteredCustomerService;

@CrossOrigin
@RestController
public class UnregisteredCustomerController {

	@Autowired
	private UnregisteredCustomerService unregisteredCustomerService;
	@Autowired
	private DocumentService documentService;

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String registerEnquiry(
			@RequestBody UnregisteredCustomerPOJO unregisteredCustomerPOJO) {
		return unregisteredCustomerService
				.registerEnquiry(unregisteredCustomerPOJO);
	}

	@RequestMapping(value = "/uploadDocuments", method = RequestMethod.POST, headers = ("content-type=multipart/*"), produces = MediaType.APPLICATION_JSON_VALUE)
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
	
	@RequestMapping(value="/verifyUnregisteredUsers", method=RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String verifyUnregisteredUsers() throws JsonProcessingException
	{
		return unregisteredCustomerService.verifyUnregisteredUsers();
	}

	@RequestMapping(value="/viewUnregisteredUsers", method=RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE,consumes= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String viewUnregisteredUserDetails(@RequestBody String id) throws JsonProcessingException
	{
		return unregisteredCustomerService.viewUnregisteredUserDetails(id);
	}
	
//	@RequestMapping(value="/sendRegistrationEmail", method=RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE,consumes= MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody String sendRegistrationEmail(@RequestBody String id) throws JsonParseException, JsonMappingException, IOException
//	{
//		System.out.println(id);
//		unregisteredCustomerService.sendEmail(id);
//		return id;
//	}
}
