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

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CaptainsLogger logger = CaptainsLogger.getLogger();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loginPage = Templates.getLoginPage();
		resp.setStatus(200);
		resp.getWriter().write(loginPage);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PirateService pirateService = new PirateService(new PirateDAO());
		resp.setContentType("application/json");
		String loginPage = Templates.getLoginPage();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		if (!pirateService.recordExists(email)) {
			resp.setStatus(404);
			logger.log(LogLevel.ERROR,
					"Email entered by pirate not in system, login failer." + " Send back with error message");

			Map<String, String> error = new HashMap<String, String>() {
				private static final long serialVersionUID = 1L;

				{
					put("error", "email not in system");
				}
			};

			ObjectMapper mapper = new ObjectMapper();

			resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));

		} else {

			Pirate pirateAtTheGates = pirateService.getPirateByEmail(email);

			// check insertion was successful
			if (!pirateService.passwordsMatch(password, pirateAtTheGates)) {

				resp.setStatus(401);
				Map<String, String> error = new HashMap<String, String>() {
					private static final long serialVersionUID = 1L;

					{
						put("error", "wrong password");
					}
				};

				ObjectMapper mapper = new ObjectMapper();

				resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));
			} else {

				resp.setStatus(201);
				req.getSession().setAttribute("pirate", pirateAtTheGates);
				req.getSession().setMaxInactiveInterval(60*60);
				resp.getWriter().write(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(pirateAtTheGates));

			}
		}

	}
}
