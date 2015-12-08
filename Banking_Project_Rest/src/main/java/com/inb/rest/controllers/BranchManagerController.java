/**
 * 
 */
package com.inb.rest.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inb.mongo.collections.BranchManager;
import com.inb.rest.entity.BranchManagerPOJO;
import com.inb.rest.entity.LoginDetails;
import com.inb.service.interfaces.BranchManagerService;

/**
 * @author jude_p
 *
 */
@RestController
public class BranchManagerController {
	
	@Autowired
	private BranchManagerService branchManagerService;
	
	@RequestMapping("/helloAll")
	public String sayHi(@RequestParam(value="name", defaultValue="Ivan") String name) {
		return "Hello " + name;
	}
	
	@RequestMapping(value="/addBranchManager", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createBranchManager(@RequestBody BranchManagerPOJO branchManager) {
		String result="";
		
		branchManager.setDateOfBirth(new Date());					//added for test case
		
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(branchManager.getDateOfBirth());
		
		Calendar calendar2=new GregorianCalendar(calendar.get(calendar.YEAR),calendar.get(calendar.MONTH),calendar.get(calendar.DAY_OF_MONTH)+1);
		
		Date isoDate=calendar2.getTime();
		System.out.println(isoDate);
		
	
		result=branchManagerService.save(new BranchManager(branchManager.getFirstName(), branchManager.getLastName(), branchManager.getEmail(),
					branchManager.getPhone(), branchManager.getAddress(), isoDate, branchManager.getUsername(), 
					branchManager.getPassword()));
			
		
		if(result.equals("Branch Manager Added"))
		{
			return "{\"result\":\"Success\"}";
		}
		else
		{
			return "{\"result\":\"Error\"}";
		}

	}
	
	@RequestMapping("/hellosss")
	public String sayHello(@RequestParam(value="name", defaultValue="Ivan") String name) {
		return "Hellosss " + name;
	}
	
	@RequestMapping(value="/loginBranchManager", method=RequestMethod.POST)
	public boolean loginBranchManager(@ModelAttribute LoginDetails loginDetails) {
		System.out.println("Inside loginBranchManager   "+loginDetails.getUsername());
		return branchManagerService.login(loginDetails.getUsername(), loginDetails.getPassword());
	}
	
}
