package com.inb;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class UnregisteredUserTest {
	static Client client;
	static WebResource target;
	
	@BeforeClass
	public static void init(){
		client = Client.create();
		target = client.resource("http://localhost:8080/unregistereduser");
	}

	@Test
	public void testGetByEmail() {
		String email = "nm@gmail.com";
		ClientResponse response=target.path("/"+email).accept("application/json").type("application/json").get(ClientResponse.class);
		assertEquals(200,response.getStatus());
	}
	
	@Test
	public void testGetByEmailOutput() {
		String email = "nm@gmail.com";
		String response=target.queryParam("email", email).accept("application/json").type("application/json").get(String.class);
		String output = "{\"id\":\"5670226df1bdecfc12c188c4\",\"firstName\":\"navin\",\"lastName\":\"maheshwari\",\"email\":\"nm@gmail.com\",\"phone\":123456,\"address\":\"Address\",\"dateOfBirth\":1450169097664,\"branch\":null,\"customerId\":132456,\"userName\":null,\"password\":null,\"authorizedImageName\":null,\"authorizedImageText\":null,\"accounthash\":null,\"login\":false}";
		assertEquals(response,output);
	}
	
	@Test
	public void testGetByEmailFailureOutput() {
		String email = "nm1234@gmail.com";
		String response=target.queryParam("email", email).accept("application/json").type("application/json").get(String.class);
		String output = "{\"alreadyExists\" : \"false\"}";
		assertEquals(response,output);
	}

}







