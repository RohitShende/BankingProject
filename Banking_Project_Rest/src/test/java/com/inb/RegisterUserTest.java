package com.inb;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RegisterUserTest {

	
	static Client client;
	static WebResource target;
	
	@BeforeClass
	public static void init(){
		client = Client.create();
		target = client.resource("http://localhost:8080/registeredcustomer");
	}

	@Test
	public void testGetById() {
		String id = "132456";
		ClientResponse response=target.path("/"+id).accept("application/json").type("application/json").get(ClientResponse.class);
		assertEquals(200,response.getStatus());
	}

	@Test
	public void testLoginAdminFailure() {
		String id = "1432456";
		String response=target.path("/"+id).accept("application/json").type("application/json").get(String.class);
		String expectedResult = "{ \"Exception\":\"No such user\" }";
		assertEquals(response,expectedResult);
	}

	@Test
	public void testApplyNewAccount() {
		//String id = "1432456";
		String input="{\"account\": { \"accountType\" : \"SAVINGACCOUNT\"},\"address\" : \"nm\",\"branchPOJO\": {},\"dateOfBirth\": \"2015-12-07T18:30:00.000Z\",\"email\": \"nm1agdfssdf@gmail.com\",\"firstName\": \"gbdfh\",\"lastName\": \"sdfgdf\",\"phone\": 1234}";
		ClientResponse response=target.accept("application/json").type("application/json").post(ClientResponse.class,input);
		assertEquals(200,response.getStatus());
	}
}



