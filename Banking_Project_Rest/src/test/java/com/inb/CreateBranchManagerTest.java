package com.inb;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.junit.Before;
import org.junit.Test;

public class CreateBranchManagerTest {
	
	
	ClientConfig config;
	Client client;
	WebTarget target;
	
	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"http://localhost:8080/addBranchManager").build();
	}
	
	@Before
	public void init(){
		config = new ClientConfig();

		client = ClientBuilder.newClient(config);

		target = client.target(getBaseURI());	
	}
	
	@Test
	public void testAddBranchManager(){

//	String jsonAnswer = target.request()
//			.accept(MediaType.APPLICATION_JSON).get(String.class);
//	
//	System.out.println(jsonAnswer);
	
		Form form =new Form();
	    form.param("firstName", "Palakh");
	    form.param("lastName", "Palakh");
	    form.param("email", "Palakh");
	    form.param("phone", "32132");
	    form.param("address", "Palakh");
	    form.param("dateOfBirth", "Palakh");
	    form.param("username", "Palakh");
	    form.param("password", "Palakh");
	    String response = (String) target.request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),String.class);
	    System.out.println("Form response " + response);
	}

}
	
	
