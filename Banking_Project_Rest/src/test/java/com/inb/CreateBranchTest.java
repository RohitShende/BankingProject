package com.inb;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class CreateBranchTest {

	static Client client;
	WebResource target;
	
	@BeforeClass
	public void init(){
		client = Client.create();
		target = client.resource("http://localhost:8080/createBranch");	
	}
	

	@Test
	public void testCreateBranch()
	{
		String testInput="{\"ifscCode\":\"B100\",\"branchName\":\"FCR\",\"contact\":123123,"
				+ "\"address\":\"FCR\"}";
		 String testResult=target.accept("application/json").type("application/json").post(String.class,testInput);
		    String expected="{\"testResult\":\"Success\"}";
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
