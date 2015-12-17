package com.inb;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class LoginAsRegistredUserTest {
	static Client client;
	static WebResource target;
	
	@BeforeClass
	public static void init(){
		client = Client.create();
		
	}

	@Test
	public void testLoginAdminSuccess() {
		target = client.resource("http://localhost:8080/registeredcustomer/login");
		String input = "{\"userName\":\"331085\",\"password\":\"navin\"}";
		ClientResponse response=target.accept("application/json").type("application/json").put(ClientResponse.class,input);
		assertEquals(200,response.getStatus());
	}

//	@Test
//	public void testLoginAdminFailure() {
//		target = client.resource("http://localhost:8080/authorisation/login");
//		String input = "{\"username\":\"nm\",\"password\":\"nmm\"}";
//		String result = target.accept("application/json").type("application/json").put(String.class, input);
//		String expected = "{ \"error\" :100,\"message\": \"Invalid Credentials\"}";
//		assertEquals(expected, result);
//	}

}
