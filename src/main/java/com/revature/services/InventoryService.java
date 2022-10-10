package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.InventoryDAO;
import com.revature.models.InventoryItem;
import com.revature.models.LineItem;
import com.revature.utils.CaptainsLogger;
import com.revature.utils.CaptainsLogger.LogLevel;


public class InventoryService {
	CaptainsLogger logger = CaptainsLogger.getLogger();

	public static void main(String[] args) {
		new InventoryService(new InventoryDAO()).getStoreInventory("captain").forEach(x -> System.out.println(x));
	}

	private InventoryDAO inventoryDAO;

	public InventoryService(InventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}

	public List<InventoryItem> getStoreInventory(String storeName) {
		
		
		List<InventoryItem> storeInventory = new ArrayList<>();
		for (InventoryItem ii : getInventoryAllLocations()) {
			if (ii.getStoreName().trim().equalsIgnoreCase(storeName))
				storeInventory.add(ii);
		}

		return storeInventory;

	}

	public List<InventoryItem> getStoreInventoryNoFix(String storeName){
		List<InventoryItem> storeInventory = new ArrayList<>();
		for (InventoryItem ii : getInventoryAllLocations()) {
			if (ii.getStoreName().equalsIgnoreCase(storeName))
				storeInventory.add(ii);
		}

		return storeInventory;

	}
	public List<InventoryItem> getInventoryAllLocations() {

		return (List<InventoryItem>) inventoryDAO.getAll();
	}

	public boolean restockInventory(String productName, int quantity, String storeName) {
		InventoryItem ii = new InventoryItem(productName, quantity, storeName);
		return inventoryDAO.update(ii);

	}

	public boolean reduceStockl(LineItem li) {
		InventoryItem toChange = null;
		logger.log(LogLevel.DEBUG,li.getStoreLocation());
		for (InventoryItem ii : getStoreInventoryNoFix(li.getStoreLocation().trim())) {
			logger.log(LogLevel.DEBUG, ii.getStoreName() + " == " +li.getStoreLocation());
			if (ii.getProductName().equalsIgnoreCase(li.getProductName())) {
				toChange = ii;
				break;
			}
		}
		if (toChange == null) {
			logger.log(LogLevel.ERROR, "Could not find item to update");
			return false;
		} else {

			toChange.setQuantity(toChange.getQuantity() - li.getQuantity());
			logger.log(LogLevel.DEBUG, "This is the item retrieved : " + toChange);

			if (inventoryDAO.update(toChange))
				return true;
			else
				return false;

		}

	}
}
