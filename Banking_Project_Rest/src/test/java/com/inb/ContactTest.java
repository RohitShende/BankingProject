package com.inb;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import static org.junit.Assert.assertEquals;

public class ContactTest {

	static Client client;
	static WebResource target;
	
	@BeforeClass
	public static void init(){
		client = Client.create();
		target = client.resource("http://localhost:8080/contact/");	
	}
	
	@Test
	public void testSendFeedbackSuccess()
	{
		String input="{\"firstName\":\"Shariful\",\"lastName\":\"Islam\",\"email\":\"shariful@mail.com\","
				+ "\"phone\":1231231230,"
				+ "\"message\":\"I want to register for more than one account,how can I?\"}";
		 ClientResponse response=target.accept("application/json").type("application/json").post(ClientResponse.class,input);
		 Assert.assertEquals(200,response.getStatus());
	}
	
	

}
