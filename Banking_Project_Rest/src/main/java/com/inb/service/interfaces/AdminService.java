package com.inb.service.interfaces;

import com.inb.exceptions.NotAdminException;
import com.inb.mongo.collections.Admin;

public interface AdminService {
	Admin login(String username , String password) throws NotAdminException;
	void logout(Admin admin); 
}
