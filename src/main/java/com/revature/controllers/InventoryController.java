package com.revature.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.InventoryDAO;
import com.revature.models.InventoryItem;
import com.revature.services.InventoryService;
import com.revature.services.LocationService;
import com.revature.utils.CaptainsLogger;
import com.revature.utils.CaptainsLogger.LogLevel;

public class InventoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private InventoryService inventoryService;
	private CaptainsLogger logger = CaptainsLogger.getLogger();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		resp.setContentType("application/json");
		inventoryService = new InventoryService(new InventoryDAO());
		
		//if no store was specified in path, serve inventory for the whole chain
		if (req.getPathInfo()==null || req.getPathInfo().replace("/", "").isEmpty()) {
			
			List<InventoryItem> chainInventory = inventoryService.getInventoryAllLocations();
			if(chainInventory==null||chainInventory.isEmpty())
			{
				logger.log(LogLevel.ERROR, "there are no products in any of the stores ");

				Map<String, String> error = new HashMap<String, String>() {
					private static final long serialVersionUID = 1L;

					{
						put("error", "we have no items to show");
					}
				};

				resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));
				
			}
				else	
			resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(chainInventory));
			
		

		} else {
			String storeLocationRequested = req.getPathInfo().replace("/", "");
			
			
		
			if (LocationService.exists(storeLocationRequested)) {
				
				List<InventoryItem> storeInventory = inventoryService.getStoreInventory(storeLocationRequested);
				
				//for when the result is nothing because the store is empty of products
				if (storeInventory == null || storeInventory.isEmpty()) {
					resp.setStatus(412);
					logger.log(LogLevel.ERROR, "this store is completely empty, nothing to show");

					Map<String, String> error = new HashMap<String, String>() {
						private static final long serialVersionUID = 1L;

						{
							put("error", "this store is completely empty");
						}
					};

					resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(error));
				} else {

					resp.getWriter().write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(storeInventory));

				}

			} else {
				//for when the path doesn't match any store names
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
