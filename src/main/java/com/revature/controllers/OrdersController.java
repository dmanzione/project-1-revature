package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.InventoryDAO;
import com.revature.dao.LineItemDAO;
import com.revature.dao.OrderDAO;
import com.revature.models.LineItem;
import com.revature.models.Order;
import com.revature.models.Pirate;
import com.revature.services.InventoryService;
import com.revature.services.LineItemService;
import com.revature.services.OrderService;
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

		if (session.getAttribute("pirate") == null) {
			resp.setStatus(401);

			logger.log(LogLevel.ERROR, "there are no products in any of the stores ");

			Map<String, String> error = new HashMap<String, String>() {
				private static final long serialVersionUID = 1L;

				{
					put("error", "Unauthorized. Please sign in");
				}
			};
			resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));

		} else {
			List<LineItem> lineItems = new ArrayList<>();
			String productNamesAsString = req.getParameter("productName");
			String[] stringArr = productNamesAsString.split(",");
			String storeLocation = req.getParameter("storeName");
			String[] quantities = req.getParameter("quantity").split(",");
			for (int i = 0; i < stringArr.length; i++) {
				LineItem li = new LineItem(stringArr[i], Integer.valueOf(quantities[i]), storeLocation);
				lineItems.add(li);
			}

			if (lineItems == null || lineItems.isEmpty()) {
				logger.log(LogLevel.ERROR, "pirate attempted to submit an order without any items added to cart");

				Map<String, String> error = new HashMap<String, String>() {

					private static final long serialVersionUID = 1L;

					{
						put("error", "Cannot submit an order without items in your cart");
					}
				};
				resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));
			}
			double totalPrice = 0.00;
			InventoryService inventoryService = new InventoryService(new InventoryDAO());

			for (LineItem li : lineItems) {
				LineItemService lineItemService = new LineItemService(new LineItemDAO());
				lineItemService.submitForPurchase(li);
				totalPrice += lineItemService.getTotalPrice(li);

				inventoryService.reduceStockl(li);
			}

			Pirate pirate = (Pirate) session.getAttribute("pirate");
			Order order = new Order(storeLocation, pirate.getId());
			order.setTotalPrice(totalPrice);
			order.setLineItems(lineItems);
			order.setStoreLocation(storeLocation);
			new OrderService(new OrderDAO()).placeOrder(order);

			resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(order));

		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		ObjectMapper mapper = new ObjectMapper();
		resp.setContentType("application/json");
		
		Pirate pirate =null;
		if (session==null||(pirate =(Pirate) session.getAttribute("pirate"))==null) {
			resp.setStatus(401);

			logger.log(LogLevel.ERROR, "unauthorized user tried to get access");

			Map<String, String> error = new HashMap<String, String>() {
				private static final long serialVersionUID = 1L;

				{
					put("error", "Unauthorized. Please sign in");
				}
			};
			resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));

		} else {

			
			
			List<Order> orders = new OrderService(new OrderDAO()).getPirateOrders(pirate.getId());
			resp.getWriter().println(mapper.writeValueAsString(orders)==null);
			if (orders == null || orders.isEmpty()) {
				resp.setStatus(204);
				resp.setContentType("application/json");
				logger.log(LogLevel.ERROR, "pirate " + pirate + " has no order history");

				Map<String, String> error = new HashMap<String, String>() {
					private static final long serialVersionUID = 1L;

					{
						put("error", "You have no orders in your order history");
					}
				};
				resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));
			} else {
				resp.setStatus(201);
				resp.setContentType("application/json");
				resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(orders));

			}
		}
	}

}
