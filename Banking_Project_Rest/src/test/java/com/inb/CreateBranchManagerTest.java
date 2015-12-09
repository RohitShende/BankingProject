package com.inb;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CreateBranchManagerTest {
	
	
	
	static Client client;
	static WebResource target;
	
	@BeforeClass
	public static void init(){
	
		client = Client.create();

		target = client.resource("http://localhost:8080/addBranchManager");
	}
	
	@Test
	public void testAddBranchManagerSuccess(){
		String input="{\"firstName\":\"Palakh\",\"lastName\":\"Palakh\",\"email\":\"Palakh124343\",\"phone\":123,"
				+ "\"address\":\"Palakh\",\"dateOfBirth\":\"1993-07-13\",\"username\":\"palakh13442\",\"password\":\"Palakh\"}";
	    ClientResponse response=target.accept("application/json").type("application/json").post(ClientResponse.class,input);
	    String result=target.accept("application/json").type("application/json").post(String.class,input);
	    System.out.println("Form response " + response);
	    System.out.println("Form result " + result);
	   Assert.assertEquals(input,result);
	   
	}

	@Test
	public void testBranchManagerExists(){
		String input="{\"firstName\":\"Palakh\",\"lastName\":\"Palakh\",\"email\":\"Palakh\",\"phone\":123,"
				+ "\"address\":\"Palakh\",\"username\":\"palakh\",\"password\":\"Palakh\"}";
	    ClientResponse response=target.accept("application/json").type("application/json").post(ClientResponse.class,input);
	    String result=target.accept("application/json").type("application/json").post(String.class,input);
	    String expected="{ \"Exception\" : \"BranchManagerExistsException\" }";
	    System.out.println("Form response " + response);
	    System.out.println("Form result " + result);
	    Assert.assertEquals(expected,result);
	}
}
	
	
