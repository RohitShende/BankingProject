package com.inb;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class LogoutAdminTest {
	
	
	
	static Client client;
	static WebResource target;
	
	@BeforeClass 
	public static void init(){
		client = Client.create();
		target = client.resource("http://localhost:8080/admin/logout");
	}
	
	
	
	@Test
	public void testLogoutAdminSuccess(){
		String input="{\"userName\": \"admin\"}";
	    ClientResponse response=target.accept("application/json").type("application/json").put(ClientResponse.class,input);
		assertEquals(200,response.getStatus());
	}
	
	@Test
	public void testLogoutAdminFailure(){
		String input="{\"userName\": \"rohitss\"}";
	    String result=target.accept("application/json").type("application/json").put(String.class,input);
	    String expected="{ \"Exception\":\"USERNAME OR PASSWORD INCORRECT/rohitss\"}";
	    assertEquals(expected,result);
	}
}
	
	
