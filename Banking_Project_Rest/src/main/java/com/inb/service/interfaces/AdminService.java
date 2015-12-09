package com.inb.service.interfaces;

import com.inb.mongo.collections.Admin;

public interface AdminService {
	String login(String username , String password);
	String save(Admin admin);
	Admin isAdmin(String id);
}
