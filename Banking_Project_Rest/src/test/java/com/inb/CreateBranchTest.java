package com.inb;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CreateBranchTest {

	static Client client;
	static WebResource target;
	
	@BeforeClass
	public static void init(){
		client = Client.create();
		target = client.resource("http://localhost:8080/createBranch");	
	}
	
	@Test
	public void testCreateBranch()
	{
		String input="{\"ifscCode\":\"BANK00100\",\"branchName\":\"FCRoad\",\"contact\":123123123,"
				+ "\"address\":\"FCRoad,Pune\"}";
		 ClientResponse response=target.accept("application/json").type("application/json").post(ClientResponse.class,input);
		 Assert.assertEquals(200,response.getStatus());
	}
	
	@Test
	public void testBranchExists(){
		String input="{\"ifscCode\":\"BANK00100\",\"branchName\":\"FCRoad\",\"contact\":123123123,"
				+ "\"address\":\"FCRoad,Pune\"}";
	    String result=target.accept("application/json").type("application/json").post(String.class,input);
	    String expected="{ \"Exception \": \"BranchAlreadyExistException\" }";
	    Assert.assertEquals(expected,result);
	}
}
