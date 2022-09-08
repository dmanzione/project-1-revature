package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.PirateDAO;
import com.revature.models.Pirate;
import com.revature.services.PirateService;


/**
 * @author DonatoManzione
 * 		   This servlet will handle requests to perform CRUD 
 * 		   operations Create and Read for Pirate records in 
 * 		   database
 *
 */
public class PirateServlet extends HttpServlet {
	Logger log = LogManager.getLogger(PirateServlet.class);
	private PirateService pirateService = new PirateService(new PirateDAO());
	
	
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			List<Pirate>pirates = pirateService.getAllPirates();
			ObjectMapper objectMapper = new ObjectMapper();
			resp.setContentType("application/json");
			resp.getWriter().write(objectMapper.writeValueAsString(pirates));
			
		}
	private static final long serialVersionUID = 1L;	
	
}
