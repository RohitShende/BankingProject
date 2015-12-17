package com.inb;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UnregisteredCustomerTest {
	
	
	
	static Client client;
	static WebResource target;
	
	@BeforeClass
	public static void init(){
	
		client=Client.create();
		target = client.resource("http://localhost:8080/unregistereduser");
	}
	
	@Test
	public void testGetUnregisteredUsers(){
		int skip=1;
		int limit=10;
		ClientResponse response=target.path("/"+skip+"/"+limit).accept("application/json").type("application/json").get(ClientResponse.class);
	   Assert.assertEquals(200,response.getStatus());
	   
	}
	
	@Test
	public void testViewUnregisteredUserDetails(){
		String id="56716acc0c49394b13e881cd";
		String response=target.path("/"+id).accept("application/json").type("application/json").get(String.class);
		String expected="[{\"id\":\"56716acc0c49394b13e881cd\",\"firstName\":\"Sachin\",\"lastName\":\"Tendulkar\",\"email\":\"sachin@gmail.com\",\"phone\":9930777889,\"address\":\"Thane\",\"dateOfBirth\":1447180200000,\"branch\":null,\"enqId\":0,\"applicationStatus\":\"Pending\",\"account\":{\"accountType\":\"SAVINGACCOUNT\",\"accountNumber\":0,\"balance\":0.0,\"interestRate\":0.0},\"login\":false}]";
		
	   Assert.assertEquals(expected,response);
	}
	
	@Test
	public void testSendRegistrationEmailSuccess(){
		String id="56714d260c49a9d815956802";
		String status="reject";
		String response=target.path("/email/"+id+"/"+status).accept("application/json").type("application/json").put(String.class);
		String expected="{ \"Success\": \"Email sent\"}";
		
	   Assert.assertEquals(expected,response);
	}
}
	
	
