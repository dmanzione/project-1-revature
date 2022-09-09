package com.revature.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.utils.LocalStorage;

public class LocationController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setStatus(200);

		Map<String, String> locations = LocalStorage.getLocations();
		ObjectMapper mapper = new ObjectMapper();

		resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(locations));
	}

}
