package com.revature.services;

import java.util.List;

import com.revature.dao.PirateDAO;
import com.revature.models.Pirate;

public class PirateService {
	PirateDAO pirateDAO;
	public PirateService(PirateDAO pirateDAO) {
			this.pirateDAO = pirateDAO;
	}
	
	public List<Pirate> getAllPirates(){
		return pirateDAO.getAllInstances();
	}

	public boolean addPirate(Pirate testPirate) {
		
		return pirateDAO.create(testPirate);
	}

	public Pirate getPirateByEmail(String email) {
		
		return pirateDAO.readBy(email);
	}

	public boolean emailTaken(String email) {
		
		return pirateDAO.readBy(email)!=null;
	}
}
