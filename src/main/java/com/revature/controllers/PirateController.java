package com.revature.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.PirateDAO;
import com.revature.models.Pirate;
import com.revature.services.PirateService;
import com.revature.utils.CaptainsLogger;

/**
 * @author DonatoManzione This servlet will handle requests to perform CRUD
 *         operations Create and Read for Pirate records in database
 *
 */

public class PirateController extends HttpServlet {
	CaptainsLogger log = CaptainsLogger.getLogger();
	private PirateService pirateService = new PirateService(new PirateDAO());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Pirate> pirates = pirateService.getAllPirates();
		ObjectMapper mapper = new ObjectMapper();
		resp.setStatus(200);
		resp.setContentType("application/json");
		resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pirates));

	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
