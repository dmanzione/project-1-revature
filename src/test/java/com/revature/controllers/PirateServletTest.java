package com.revature.controllers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.dao.PirateDAO;
import com.revature.models.Pirate;
import com.revature.services.PirateService;

public class PirateServletTest {
	private static PirateService pirateService;
	private static PirateDAO pirateDAO;
	
	@BeforeAll
	public static void initializeFields() {
		
		pirateDAO = new PirateDAO();
		pirateService = new PirateService(pirateDAO);
	}
	@Test
	public void testGetAllPirates() {
		List<Pirate> piratesTest = pirateService.getAllPirates();
		
		assertNotNull(piratesTest);
		assertFalse(piratesTest.isEmpty());
		piratesTest.forEach(x-> System.out.println(x));
		
	}
}
