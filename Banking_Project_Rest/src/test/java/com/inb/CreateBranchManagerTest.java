package com.inb;

import org.json.simple.JSONObject;
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
	
		client=Client.create();
		target = client.resource("http://localhost:8080/addBranchManager");
	}
	
	@Test
	public void testAddBranchManagerResponseStatus(){
		String input="{\"firstName\":\"Palakh\",\"lastName\":\"Palakh\",\"email\":\"Palakh\",\"phone\":123,"
				+ "\"address\":\"Palakh\",\"username\":\"palakh\",\"password\":\"Palakh\"}";
	    ClientResponse response=target.accept("application/json").type("application/json").post(ClientResponse.class,input);
	   Assert.assertEquals(200,response.getStatus());
	   
	}
	
	@Test
	public void testBranchManagerExists(){
		String input="{\"firstName\":\"Palakh\",\"lastName\":\"Palakh\",\"email\":\"Palakh\",\"phone\":123,"
				+ "\"address\":\"Palakh\",\"username\":\"palakh\",\"password\":\"Palakh\"}";
	    ClientResponse response=target.accept("application/json").type("application/json").post(ClientResponse.class,input);
	    String result=target.accept("application/json").type("application/json").post(String.class,input);
	    String expected="{ \"Exception\": \"BranchManagerExistsException\"}";
	    Assert.assertEquals(expected,result);
	}
}
	
	
