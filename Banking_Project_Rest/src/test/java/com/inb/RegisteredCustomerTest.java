package com.inb;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RegisteredCustomerTest {
	
	
	static Client client;
	static WebResource target;
	
	@BeforeClass
	public static void init(){
	
		client=Client.create();
		target = client.resource("http://localhost:8080/registeredcustomer");
	}
	
	@Test
	public void testViewRegisteredUserDetailsStatus(){
		String id="56716acc0c49394b13e881cd";
		ClientResponse response=target.path("/details/"+id).accept("application/json").type("application/json").get(ClientResponse.class);
	   Assert.assertEquals(200,response.getStatus());
	}
	
	@Test
	public void testViewAllRegisteredUserDetailsStatus(){
		ClientResponse response=target.path("/").accept("application/json").type("application/json").get(ClientResponse.class);
	   Assert.assertEquals(200,response.getStatus());
	}
	
}
	
	
