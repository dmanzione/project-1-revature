package com.revature.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.PirateDAO;
import com.revature.models.Pirate;
import com.revature.services.PirateService;
import com.revature.utils.CaptainsLogger;
import com.revature.utils.CaptainsLogger.LogLevel;
import com.revature.utils.Templates;

public class SignupController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private PirateService pirateService;
	private CaptainsLogger logger = CaptainsLogger.getLogger();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String signupPage = Templates.getSignupPage();
		resp.setStatus(200);
		resp.getWriter().write(signupPage);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String email = req.getParameter("email");
		String lastName = req.getParameter("lastName");
		String password = req.getParameter("password");
		logger.log(LogLevel.DEBUG, "in dopost");
		resp.setContentType("application/json");

		// check email isn't already i
		pirateService = new PirateService(new PirateDAO());

		if (pirateService.recordExists(email)) {
			resp.setStatus(412);
			logger.log(LogLevel.ERROR, "email taken");
			
			Map<String, String> error = new HashMap<String, String>() {
				private static final long serialVersionUID = 1L;

				{
					put("error", "email is taken");
				}
			};

			ObjectMapper mapper = new ObjectMapper();

			resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));

		} else {

			Pirate newPirate = new Pirate(firstName, lastName, email, password);
			logger.log(LogLevel.DEBUG, "creating pirate object from form inputs : " + newPirate);
			// check insertion was successful
			if (!pirateService.addPirate(newPirate)) {

				resp.setStatus(417);
				Map<String, String> error = new HashMap<String, String>() {
					private static final long serialVersionUID = 1L;

					{
						put("error", "account could not be created");
					}
				};

				ObjectMapper mapper = new ObjectMapper();

				resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));
			} else {
				new PirateDAO().create(newPirate);
				resp.setStatus(201);
				resp.sendRedirect("/revPirate/pirates");

			}
		}

	}

}
