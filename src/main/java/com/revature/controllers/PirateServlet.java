package com.revature.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * @author DonatoManzione This servlet will handle requests to perform CRUD
 *         operations Create and Read for Pirate records in database
 *
 */
public class PirateServlet extends HttpServlet {
	Logger log = LogManager.getLogger(PirateServlet.class);
	private PirateService pirateService = new PirateService(new PirateDAO());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Pirate> pirates = pirateService.getAllPirates();
		ObjectMapper objectMapper = new ObjectMapper();
		resp.setContentType("application/json");
		resp.getWriter().write(objectMapper.writeValueAsString(pirates));

	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("first_name");
		String email = req.getParameter("email");
		String lastName = req.getParameter("last_name");
		String password = req.getParameter("password");

		resp.setContentType("application/json");

		// check email isn't already i
		if (pirateService.emailTaken(email)) {
			resp.setStatus(412);

			Map<String, String> error = new HashMap<String, String>() {
				private static final long serialVersionUID = 1L;

				{
					put("error", "email is taken");
				}
			};

			ObjectMapper mapper = new ObjectMapper();

			resp.getWriter().write(mapper.writeValueAsString(error));

		}

		Pirate newPirate = new Pirate(firstName, lastName, email, password);

		// check insertion was successful
		if (pirateService.addPirate(newPirate)) {

			resp.setStatus(417);
			Map<String, String> error = new HashMap<String, String>() {
				private static final long serialVersionUID = 1L;

				{
					put("error", "account could not be created");
				}
			};

			ObjectMapper mapper = new ObjectMapper();

			resp.getWriter().write(mapper.writeValueAsString(error));
		}

		// check insertion was successful
		pirateService.addPirate(newPirate);
		resp.setStatus(201);
		resp.sendRedirect("/revPirate/pirates");

	}
}
