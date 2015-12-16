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
		target = client.resource("http://localhost:8080/branchmanager/login");
	}
	
	
	
	@Test
	public void testLoginBranchManagerSuccess(){
		String input="{\"userName\": \"palakh\",\"password\": \"Palakh\"}";
	    ClientResponse response=target.accept("application/json").type("application/json").put(ClientResponse.class,input);
		assertEquals(200,response.getStatus());
	}
	
	@Test
	public void testLoginBranchManagerFailure(){
		String input="{\"userName\": \"rohitss\",\"password\": \"12345678\"}";
	    String result=target.accept("application/json").type("application/json").put(String.class,input);
	    String expected="{ \"Exception\":\"USERNAME OR PASSWORD INCORRECT/rohitss\"}";
	    assertEquals(expected,result);
	}

}
	
	
