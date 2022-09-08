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
}
