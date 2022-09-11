package com.revature.controllers;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.InventoryDAO;
import com.revature.dao.LineItemDAO;
import com.revature.dao.ProductDAO;
import com.revature.models.InventoryItem;
import com.revature.models.LineItem;
import com.revature.models.Product;
import com.revature.services.InventoryService;
import com.revature.services.LineItemService;
import com.revature.services.LocationService;
import com.revature.services.ProductService;
import com.revature.utils.CaptainsLogger;
import com.revature.utils.CaptainsLogger.LogLevel;

public class InventoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private InventoryService inventoryService;
	private CaptainsLogger logger = CaptainsLogger.getLogger();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductService productService = new ProductService(new ProductDAO());
		resp.setContentType("application/json");
		String productName = req.getParameter("productName");
		int quantity = Integer.valueOf(req.getParameter("quantity"));
		String storeName = req.getParameter("storeName");
		inventoryService = new InventoryService(new InventoryDAO());

		if (!productService.isSoldAtStores(productName)) {

			logger.log(LogLevel.ERROR, "attempt to replenish stock of product with unknown name");

			Map<String, String> error = new HashMap<String, String>() {
				private static final long serialVersionUID = 1L;

				{
					put("error",
							"We have no products registered with that name. Did you mean to introduce a new product?");
				}
			};
			ObjectMapper mapper = new ObjectMapper();
			resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));
		} else {

			if (inventoryService.restockInventory(productName, quantity, storeName)) {
				InventoryItem newItem = new InventoryItem(productName, quantity, storeName);
				resp.setStatus(201);
				ObjectMapper mapper = new ObjectMapper();
				resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newItem));

			} else {

				logger.log(LogLevel.ERROR, "attempt to replenish stock of product failed. see logs for details ");

				Map<String, String> error = new HashMap<String, String>() {
					private static final long serialVersionUID = 1L;

					{
						put("error", "could not replenish inventory");
					}
				};
				ObjectMapper mapper = new ObjectMapper();
				resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));

			}

		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		resp.setContentType("application/json");
		inventoryService = new InventoryService(new InventoryDAO());

		// if no store was specified in path, serve inventory for the whole chain
		if (req.getPathInfo() == null || req.getPathInfo().replace("/", "").isEmpty()) {

			// in case there are no products for sale in any of the stores
			List<InventoryItem> chainInventory = inventoryService.getInventoryAllLocations();
			if (chainInventory == null || chainInventory.isEmpty()) {
				logger.log(LogLevel.ERROR, "there are no products in any of the stores ");

				Map<String, String> error = new HashMap<String, String>() {
					private static final long serialVersionUID = 1L;

					{
						put("error", "we have no items to show");
					}
				};

				resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));

			} else
				// display items
				resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(chainInventory));

		} else {
			// in case there is a store name as a path

			String storeLocationRequested = LocationService.fixLocationName(req.getPathInfo());

			resp.getWriter()
					.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(storeLocationRequested));
			if (LocationService.exists(storeLocationRequested)) {

				// check if name matches
				List<InventoryItem> storeInventory = inventoryService.getStoreInventory(storeLocationRequested.trim());

				// for when the result is nothing because the store is empty of products
				if (storeInventory == null || storeInventory.isEmpty()) {
					resp.setStatus(412);
					logger.log(LogLevel.ERROR, "this store is completely empty, nothing to show");

					Map<String, String> error = new HashMap<String, String>() {
						private static final long serialVersionUID = 1L;

						{
							put("error", "store " + storeLocationRequested + " is completely empty");
						}
					};

					resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));
				} else {

					List<Map<String, String>> listMap = new ArrayList<>();

					for (InventoryItem ii : storeInventory) {
						Map<String, String> inventoryItemAsMap = new HashMap<>();
						for (int i = 1; i <= 3; i++) {

							if (i == 1)
								inventoryItemAsMap.put("productName", ii.getProductName());
							else if (i == 2)
								inventoryItemAsMap.put("storeName", ii.getStoreName());
							else
								inventoryItemAsMap.put("quantity", String.valueOf(ii.getQuantity()));
							
							
							double total = new LineItemService(new LineItemDAO()).getTotalPrice(new LineItem(ii.getProductName(),ii.getQuantity(), storeLocationRequested));
							
							inventoryItemAsMap.put("totalPrice", String.valueOf(total));
						}

					}
					resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(storeInventory));

				}

			} else {
				// for when the path doesn't match any store names
				resp.setStatus(412);
				logger.log(LogLevel.ERROR, "bad input, no such store");

				Map<String, String> error = new HashMap<String, String>() {
					private static final long serialVersionUID = 1L;

					{
						put("error", "no such store");
					}
				};

				resp.setContentType("application/json");
				resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));
			}
		}
	}
}
