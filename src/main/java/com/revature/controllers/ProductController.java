package com.revature.controllers;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.StoreService;

public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StoreService storeService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setStatus(200);
		resp.setContentType("text/html");
		Map<String, String> stores = storeService.getAllLocations();
		ObjectMapper mapper = new ObjectMapper();
		
		
		String fullPage =mapper.writerWithDefaultPrettyPrinter().writeValueAsString(stores);
		resp.getWriter().write(fullPage);

	}
}
