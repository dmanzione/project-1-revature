package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.InventoryDAO;
import com.revature.models.InventoryItem;

public class InventoryService {
	public static void main(String[] args) {
		new InventoryService(new InventoryDAO()).getStoreInventory("captain").forEach(x -> System.out.println(x));
	}

	private InventoryDAO inventoryDAO;

	public InventoryService(InventoryDAO inventoryDAO) {
		this.inventoryDAO = inventoryDAO;
	}

	public List<InventoryItem> getStoreInventory(String storeName) {
		storeName = LocationService.fixLocationName(storeName);

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

}
