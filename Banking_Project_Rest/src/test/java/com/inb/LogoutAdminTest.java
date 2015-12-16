package com.inb;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class LogoutAdminTest {
	
	
	
	static Client client;
	static WebResource target;
	
	@BeforeClass 
	public static void init(){
		client = Client.create();
		target = client.resource("http://localhost:8080/admin/logout");
	}
	
	
	
	@Test
	public void testLogoutAdminSuccess(){
		String input="{\"role\": \"admin\",\"id\": \"567151b331130956e1028033\"}";
		String result=target.accept("application/json").type("application/json").put(String.class,input);
	    String expected="{ \"logoutMsg\" :\"success\"}";
	    assertEquals(expected,result);
	}
	
	@Test
	public void testLogoutAdminFailureDueToRole(){
		String input="{\"role\": \"branchmanager\",\"id\": \"567151b331130956e1028033\"}";
	    String result=target.accept("application/json").type("application/json").put(String.class,input);
	    String expected="{ \"logoutMsg\" :\"You Are Not Admin\"}";
	    assertEquals(expected,result);
	}
	
	@Test
	public void testLogoutAdminFailureDueToNotLoggedIn(){
		String input="{\"role\": \"admin\",\"id\": \"567151b331130956e1028033\"}";
	    String result=target.accept("application/json").type("application/json").put(String.class,input);
	    String expected="{ \"logoutMsg\" :\"You Are Not Logged In or Session Expired\"}";
	    assertEquals(expected,result);
	}
}
	
	
