package com.inb;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class LoginBranchManagerTest {
	
	
	
	static Client client;
	static WebResource target;
	
	@BeforeClass 
	public static void init(){
		client = Client.create();
		target = client.resource("http://localhost:8080/loginBranchManager");
	}
	
	
	
	
	
	@Test
	public void testLoginBranchManagerSuccess(){
		String input="{\"username\": \"rohit\",\"password\": \"12345678\"}";
	    ClientResponse response=target.accept("application/json").type("application/json").post(ClientResponse.class,input);
		assertEquals(200,response.getStatus());
	}
	
	
	
	@Test
	public void testLoginBranchManagerFailure(){
		String input="{\"username\": \"rohit\",\"password\": \"2345678\"}";
	    String result=target.accept("application/json").type("application/json").post(String.class,input);
	    String expected="{ Exception : \"USERNAME OR PASSWORD INCORRECT/rohit\" }";
	    assertEquals(expected,result);
	   
	}

}
	
	
