package com.inb;

import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import junit.framework.Assert;

public class CreateBranchTest {

	Client client;
	WebResource target;
	
	@Before
	public void init(){
		client = Client.create();
		target = client.resource("http://localhost:8080/createBranch");	
	}
	

	@Test
	public void testCreateBranch()
	{
		String testInput="{\"ifscCode\":\"B111\",\"branchName\":\"FCR\",\"contact\":123123,"
				+ "\"address\":\"FCR\"}";
		ClientResponse response=target.accept("application/json").type("application/json").post(ClientResponse.class,testInput);
		 String testResult=target.accept("application/json").type("application/json").post(String.class,testInput);
		    String expected="{\"testResult\":\"Success\"}";
		    System.out.println("Response : " + response);
		    System.out.println("Result : " + testResult);
		    Assert.assertEquals(expected,testResult);
	/*	Form form =new Form();
	    form.param("ifscCode", "B123");
	    form.param("branchName", "Baner");
	    form.param("contact", "321321");
	    form.param("address", "Baner Pune");
	    String response = (String) target.request().post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),String.class);
	    System.out.println("Form response " + response);*/
	}
}
