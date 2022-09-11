package com.revature.services;

import com.revature.dao.AdminDAO;

public class AdminService {

	private AdminDAO adminDAO;
	public AdminService(AdminDAO adminDAO) {
		this.adminDAO= adminDAO;
	}
	public boolean adminExists(String name) {
		
		return adminDAO.read(name) != null;
	
		
	}
}
