package com.inb;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class LogoutBranchManagerTest {
	
	
	
	static Client client;
	static WebResource target;
	
	@BeforeClass 
	public static void init(){
		client = Client.create();
		target = client.resource("http://localhost:8080/branchmanager/logout");
	}
	
	@Test
	public void testLogoutBranchManagerSuccess(){
		String input="{\"role\": \"branchmanager\",\"id\": \"566e9deb31139801e4ae6532\"}";
		String result=target.accept("application/json").type("application/json").put(String.class,input);
	    String expected="{ \"logoutMsg\" :\"success\"}";
	    assertEquals(expected,result);
	}
	
	@Test
	public void testLogoutBranchManagerFailureDueToRoleUI(){
		String input="{\"role\": \"admin\",\"id\": \"566e9deb31139801e4ae6532\"}";
	    String result=target.accept("application/json").type("application/json").put(String.class,input);
	    String expected="{ \"logoutMsg\" :\"You Are Not Branch Manager\"}";
	    assertEquals(expected,result);
	}
	
	@Test
	public void testLogoutBranchManagerFailureDueToRoleDB(){
		String input="{\"role\": \"branchmanager\",\"id\": \"566e9deb31139801e4ae65ee\"}";
	    String result=target.accept("application/json").type("application/json").put(String.class,input);
	    String expected="{ \"logoutMsg\" :\"You Are Not Branch Manager\"}";
	    assertEquals(expected,result);
	}
	
	@Test
	public void testLogoutBranchManagerFailureDueToNotLoggedIn(){
		String input="{\"role\": \"branchmanager\",\"id\": \"566e9deb31139801e4ae6532\"}";
	    String result=target.accept("application/json").type("application/json").put(String.class,input);
	    String expected="{ \"logoutMsg\" :\"You Are Not Logged In or Session Expired\"}";
	    assertEquals(expected,result);
	}
}
	
	
