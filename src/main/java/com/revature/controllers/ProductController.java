package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
		String header = "<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<title>The Pirate Store Chain</title>\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
				+ "\n"
				+ "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n"
				+ "\n"
				+ "\n"
				+ "<div class=\"w3-brown w3-container w3-center\"><h1 \n"
				+ "class=\"w3-main\"><br>Welcome to the Pirate Supply \n"
				+ "Store!</h1><br><br><br></div>\n"
				+ "\n"
				+ "<div class=\"w3-sand  w3-container\" style=\"word-wrap: break-word; \n"
				+ "white-space: pre-wrap;line-height:1.8\">";
			
		String footer = "<div class=\"w3-third\"><br></div><div class=\"w3-half\">\n" + "\n" + "</div>\n" + "\n" + "\n"
				+ "</div>\n" + "\n" + "\n" + "</body>\n" + "</html>\n" + "";
		resp.setStatus(200);
		resp.setContentType("text/html");
		Map<String, String> stores = storeService.getAllLocations();
		ObjectMapper mapper = new ObjectMapper();
	
		
		String fullPage = header + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(stores)+ footer;
		resp.getWriter().write(fullPage);

	}
}
