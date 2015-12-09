package com.inb;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class AdminLoginTest {

	
	static Client client;
	static WebResource target;
	
	@Before
	public static void init(){
		client = Client.create();
		target = client.resource("http://localhost:8080/loginAdmin");
	}

	@Test
	public void testLoginAdminSuccess() {
		String input = "{\"username\":\"nm\",\"password\":\"nm\"}";
		String result = target.accept("application/json")
				.type("application/json").post(String.class, input);
		String expected = "{\"id\":\"5666bd07f1bdf2fa152fde6e\",\"firstName\":\"Navin\",\"lastName\":\"mahesh\",\"email\":\"nm@gmail.com\",\"phone\":123,\"address\":\"MYaddress\",\"dateOfBirth\":1417977000000,\"username\":\"nm\",\"password\":\"nm\"}";
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testLoginAdminFailure() {
		String input = "{\"username\":\"nm\",\"password\":\"nmm\"}";
		String result = target.accept("application/json")
				.type("application/json").post(String.class, input);
		String expected = "{ \"error\" :100}";
		Assert.assertEquals(expected, result);
	}

}
