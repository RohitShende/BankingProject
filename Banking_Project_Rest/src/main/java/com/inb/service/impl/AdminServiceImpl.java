package com.inb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inb.exceptions.NotAdminException;
import com.inb.mongo.collections.Admin;
import com.inb.mongo.repositories.AdminRepository;
import com.inb.service.interfaces.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	MongoOperations mongoOperations;
	
	public String login(String userName, String password) {
		String adminJson = "";
		try {
			Admin admin = null;
			List<Admin> list = adminRepository.findByUsernameAndPassword(
					userName, password);
			
			if (list.size()==0) {
				throw new NotAdminException("Invalid Credentials");
			}
			admin =list.get(0);
			admin.setLogin(true);
			mongoOperations.save(admin);
			ObjectMapper mapper = new ObjectMapper();
			adminJson = mapper.writeValueAsString(admin);
		} catch (JsonProcessingException e) {
			adminJson = "{ \"error\" :\"JsonProcessingException\",\"message\": \""
					+ e.getMessage() + "\"}";
		} catch (NotAdminException e) {
			adminJson = "{ \"error\" :" + 100 + ",\"message\": \""
					+ e.getMessage() + "\"}";
		}
		return adminJson;
	}

	public Admin isAdmin(String id) {
		List<Admin> list = adminRepository.findById(id);
		return list == null ? null : list.get(0);
	}

	public String save(Admin admin) {
		ObjectMapper mapper = new ObjectMapper();
		String adminJson = "";
		try {
			adminJson = mapper
					.writeValueAsString(adminRepository.insert(admin));
		} catch (JsonProcessingException e) {
			adminJson = "{ \"error\" :\"JsonProcessingException\",\"message\": \""
					+ e.getMessage() + "\"}";
		}
		return adminJson;

	}

	public String logout(String role, String id){
		String adminJson = "";
			if(role.equals("admin"))
			{
				BasicQuery basicQuery= new BasicQuery("{ \"_id\" : \""+id+"\" }");
				Admin admin=mongoOperations.findOne(basicQuery, Admin.class);
				if(admin.isLogin())
				{
					admin.setLogin(false);
					mongoOperations.save(admin);
					adminJson = "{ \"logoutMsg\" :\"success\"}";
				}
				else
				{
					adminJson = "{ \"logoutMsg\" :\"You Are Not Logged In or Session Expired\"}";
				}
			}
			else
			{
				adminJson = "{ \"logoutMsg\" :\"You Are Not Admin\"}";
			}
			
		return adminJson;
	}
}
