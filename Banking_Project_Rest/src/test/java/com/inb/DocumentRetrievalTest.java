package com.inb;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DocumentRetrievalTest {
	
	
	
	static Client client;
	static WebResource target;
	
	@BeforeClass
	public static void init(){
	
		client=Client.create();
		target = client.resource("http://localhost:8080/");
	}
	
	@Test
	public void testGetAddressProofDocumentsSuccess(){
		String id="56716acc0c49394b13e881cd";
		ClientResponse response=target.path("addressproofdocument/"+id).accept("application/json").type("application/json").get(ClientResponse.class);
	   Assert.assertEquals(200,response.getStatus());
	   
	}
	
	@Test
	public void testGetAgeProofDocumentsSuccess(){
		String id="56716acc0c49394b13e881cd";
		ClientResponse response=target.path("ageproofdocument/"+id).accept("application/json").type("application/json").get(ClientResponse.class);
	   Assert.assertEquals(200,response.getStatus());
	   
	}
	
	@Test
	public void testGetAddressProofDocumentsFailure(){
		String id="56716acc0c49394b13e881c4";
		String expected="{\"Error\":\"No address proof document uploaded\"}";
		String result=target.path("addressproofdocument/"+id).accept("application/json").type("application/json").get(String.class);
	   Assert.assertEquals(expected,result);
	   
	}
	
	@Test
	public void testGetAgeProofDocumentsFailure(){
		String id="56716acc0c49394b13e881c4";
		String expected="{\"Error\":\"No age proof document uploaded\"}";
		String result=target.path("ageproofdocument/"+id).accept("application/json").type("application/json").get(String.class);
	   Assert.assertEquals(expected,result);
	   
	}
	
//	@Test
//	public void testBranchManagerExists(){
//		String input="{\"firstName\":\"Palakh\",\"lastName\":\"Palakh\",\"email\":\"Palakh\",\"phone\":123,"
//				+ "\"address\":\"Palakh\",\"dateOfBirth\":\"1993-07-13\",\"userName\":\"palakh\",\"password\":\"Palakh\"}";
//	    String result=target.accept("application/json").type("application/json").post(String.class,input);
//	    result=target.accept("application/json").type("application/json").post(String.class,input);
//	    String expected="{ \"Exception\": \"BranchManagerExistsException\"}";
//	    Assert.assertEquals(expected,result);
//	}
}
	
	
