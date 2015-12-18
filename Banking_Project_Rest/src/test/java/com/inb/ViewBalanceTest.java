package com.inb;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ViewBalanceTest {
	
	
	
	static Client client;
	static WebResource target;
	
	@BeforeClass
	public static void init(){
	
		client=Client.create();
		target = client.resource("http://localhost:8080/registeredcustomer");
	}
	
	@Test
	public void testGetAccountDetailsSuccess(){
		long id=390912;
		ClientResponse response=target.path("/account/"+id).accept("application/json").type("application/json").get(ClientResponse.class);
	   Assert.assertEquals(200,response.getStatus());
	   
	}
	
	@Test
	public void testGetAccountDetailsFailure(){
		long id=429885;
		String response=target.path("/account/"+id).accept("application/json").type("application/json").get(String.class);
		String expected="{\"Error\":\"No accounts to display\"}";
	   Assert.assertEquals(expected,response);
	}
}
	
	
