package com.inb.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inb.exceptions.NotAdminException;
import com.inb.mongo.collections.Admin;
import com.inb.mongo.repositories.AdminRepository;
import com.inb.service.interfaces.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public Admin login(String username, String password)
			throws NotAdminException {

		List<Admin> listAdmin = adminRepository.findAll();
		Iterator<Admin> iterator = listAdmin.iterator();
		Admin admin = null;
		while (iterator.hasNext()) {
			Admin temp = iterator.next();
			
			if (temp.getUsername().equalsIgnoreCase(username)
					&& temp.getPassword().equalsIgnoreCase(password)) {
				admin = new Admin();
				admin = temp;
				break;
			}
		}

		if (admin == null) {
			throw new NotAdminException();
		}
		return admin;

	}

	public void logout(Admin admin) {
		// TODO Auto-generated method stub

	}

	public void save(Admin admin) {
		adminRepository.insert(admin);
	}

}
