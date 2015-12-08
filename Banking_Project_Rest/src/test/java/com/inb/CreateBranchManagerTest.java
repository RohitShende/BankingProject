package com.inb;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import junit.framework.Assert;

public class CreateBranchManagerTest {
	
	
	
	Client client;
	WebResource target;
	
	@Before
	public void init(){
	
		client = Client.create();

		target = client.resource("http://localhost:8080/addBranchManager");
	}
	
	@Test
	public void testAddBranchManagerSuccess(){
		String input="{\"firstName\":\"Palakh\",\"lastName\":\"Palakh\",\"email\":\"Palakh\",\"phone\":123,"
				+ "\"address\":\"Palakh\",\"username\":\"palakh\",\"password\":\"Palakh\"}";
	    ClientResponse response=target.accept("application/json").type("application/json").post(ClientResponse.class,input);
	    String result=target.accept("application/json").type("application/json").post(String.class,input);
	    String expected="{\"result\":\"Success\"}";
	    System.out.println("Form response " + response);
	    System.out.println("Form result " + result);
	    Assert.assertEquals(expected,result);
	   
	}

	@Test
	public void testAddBranchManagerError(){
		String input="{\"firstName\":\"Palakh\",\"lastName\":\"Palakh\",\"email\":\"Palakh\",\"phone\":123,"
				+ "\"address\":\"Palakh\",\"username\":\"palakh\",\"password\":\"Palakh\"}";
	    ClientResponse response=target.accept("application/json").type("application/json").post(ClientResponse.class,input);
	    String result=target.accept("application/json").type("application/json").post(String.class,input);
	    String expected="{\"result\":\"Error\"}";
	    System.out.println("Form response " + response);
	    System.out.println("Form result " + result);
	    Assert.assertEquals(expected,result);
	}
}
	
	
