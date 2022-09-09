package com.revature.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.OrderDAO;
import com.revature.dao.PirateDAO;
import com.revature.models.Order;
import com.revature.models.Pirate;
import com.revature.services.OrderService;
import com.revature.services.PirateService;
import com.revature.utils.CaptainsLogger;
import com.revature.utils.CaptainsLogger.LogLevel;

public class OrdersController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CaptainsLogger logger = CaptainsLogger.getLogger();


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		ObjectMapper mapper = new ObjectMapper();
		resp.setContentType("application/json");
		
		if(session.getAttribute("pirate")==null) {
			resp.setStatus(401);
			
			logger.log(LogLevel.ERROR, "there are no products in any of the stores ");

			Map<String, String> error = new HashMap<String, String>() {
				private static final long serialVersionUID = 1L;

				{
					put("error", "Unauthorized. Please sign in");
				}
			};
			resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));
			
		}else {
		
			Pirate pirate = (Pirate) session.getAttribute("pirate");
			resp.setStatus(204);
			List<Order> orders = new OrderService(new OrderDAO()).getPirateOrders(pirate.getId());
			
			if(orders==null || orders.isEmpty()) {
				resp.setStatus(204);
				
				logger.log(LogLevel.ERROR, "pirate " + pirate + " has no order history");

				Map<String, String> error = new HashMap<String, String>() {
					private static final long serialVersionUID = 1L;

					{
						put("error", "Unauthorized. Please sign in");
					}
				};
				resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));
			}else {
				resp.setStatus(201);
				resp.setContentType("application/json");
				resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(orders));
				
			}
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();

		ObjectMapper mapper = new ObjectMapper();
		resp.setContentType("application/json");
		
		if(session.getAttribute("pirate")==null) {
			resp.setStatus(401);
			
			logger.log(LogLevel.ERROR, "unauthorized user tried to get access");

			Map<String, String> error = new HashMap<String, String>() {
				private static final long serialVersionUID = 1L;

				{
					put("error", "Unauthorized. Please sign in");
				}
			};
			resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));
			
		}else {
		
			Pirate pirate = (Pirate) session.getAttribute("pirate");
			resp.setStatus(204);
			List<Order> orders = new OrderService(new OrderDAO()).getPirateOrders(pirate.getId());
			
			if(orders==null || orders.isEmpty()) {
				resp.setStatus(204);
				
				logger.log(LogLevel.ERROR, "pirate " + pirate + " has no order history");

				Map<String, String> error = new HashMap<String, String>() {
					private static final long serialVersionUID = 1L;

					{
						put("error", "Unauthorized. Please sign in");
					}
				};
				resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));
			}else {
				resp.setStatus(201);
				resp.setContentType("application/json");
				resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(orders));
				
			}
		}
	}
	
	

	
	
	

	
	
	
}
