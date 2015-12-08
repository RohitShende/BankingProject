package com.inb;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@SuppressWarnings("deprecation")
public class LoginBranchManagerTest {
	
	
	
	Client client;
	WebResource target;
	
	@Before
	public void init(){
	
		client = Client.create();

		target = client.resource("http://localhost:8080/loginBranchManager");
	}
	
	
	
	
	
	@Test
	public void testLoginBranchManagerSuccess(){
		String input="{\"username\": \"rohit\",\"password\": \"12345678\"}";
	    ClientResponse response=target.accept("application/json").type("application/json").post(ClientResponse.class,input);
	    String result=target.accept("application/json").type("application/json").post(String.class,input);
	    String expected="{\"id\":\"5666ab2931130ae17f8ab5e8\",\"firstName\":\"Rohit\",\"lastName\":\"Shende\",\"email\":\"rohitshende16@gmail.com\",\"phone\":8793118499,\"address\":\"Pune\",\"dateOfBirth\":765916200000,\"username\":\"rohit\",\"password\":\"12345678\"}";
	    System.out.println("Form response " + response);
	    System.out.println("Form result " + result);
	    Assert.assertEquals(expected,result);
	   
	}
	
	
	
	@Test
	public void testLoginBranchManagerFailure(){
		String input="{\"username\": \"rohit\",\"password\": \"2345678\"}";
	    ClientResponse response=target.accept("application/json").type("application/json").post(ClientResponse.class,input);
	    String result=target.accept("application/json").type("application/json").post(String.class,input);
	    String expected="{ \"error\" :100 , \"Exception\" : \"NotBranchManagerException\" }";
	    System.out.println("Form response " + response);
	    System.out.println("Form result " + result);
	    Assert.assertEquals(expected,result);
	   
	}

}
	
	
