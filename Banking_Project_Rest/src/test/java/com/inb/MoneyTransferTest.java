package com.inb;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class MoneyTransferTest {
	
	static Client client;
	static WebResource target;
	
	@BeforeClass
	public static void init(){
		client = Client.create();
		target = client.resource("http://localhost:8080/admin/login");
	}

	@Test
	public void transferMoney() {
		String input = "{\"clientAccount\" : 123456798 \"recevierAccount\" : 12345, \"amount\" : 3000.0}";
		ClientResponse response=target.accept("application/json").type("application/json").put(ClientResponse.class,input);
		assertEquals(200,response.getStatus());
	}
	
	@Test
	public void transferMoneyInvalidAccount() {
		String input = "{\"clientAccount\" : 123456798 \"recevierAccount\" : 122345345, \"amount\" : 3000.0}";
		String response=target.accept("application/json").type("application/json").put(String.class,input);
		String output = "{\"Status\":\"Failed\",\"Message\": \"Low Balance1\"}";
		assertEquals(response,output);
	}

	
	@Test
	public void transferMoneyInvalidAccountNumber() {
		String input = "{\"clientAccount\" : 1234fdgdfg56798 \"recevierAccount\" : 122345345, \"amount\" : 3000.0}";
		ClientResponse response=target.accept("application/json").type("application/json").put(ClientResponse.class,input);
		assertEquals(400,response.getStatus());
	}

}
