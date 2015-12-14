package com.inb;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AdminLoginTest {

	
	static Client client;
	static WebResource target;
	
	@BeforeClass
	public static void init(){
		client = Client.create();
		target = client.resource("http://localhost:8080/admin/login");
	}

	@Test
	public void testLoginAdminSuccess() {
		String input = "{\"userName\":\"admin\",\"password\":\"password123\"}";
		ClientResponse response=target.accept("application/json").type("application/json").post(ClientResponse.class,input);
		assertEquals(200,response.getStatus());
	}

	@Test
	public void testLoginAdminFailure() {
		String input = "{\"username\":\"nm\",\"password\":\"nmm\"}";
		String result = target.accept("application/json").type("application/json").post(String.class, input);
		String expected = "{ \"error\" :100,\"message\": \"Invalid Credentials\"}";
		assertEquals(expected, result);
	}

}
