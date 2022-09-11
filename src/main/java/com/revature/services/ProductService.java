package com.revature.services;

import java.util.List;

import com.revature.dao.InventoryDAO;
import com.revature.dao.LocationDAO;
import com.revature.dao.ProductDAO;
import com.revature.models.InventoryItem;
import com.revature.models.Product;

public class ProductService {
	
	private ProductDAO productDAO;

	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public List<Product> getAllProducts() {
		List<Product> products = productDAO.readAll();
		List<InventoryItem> inventory = new InventoryService(new InventoryDAO()).getInventoryAllLocations();
		
		
		for(Product p : products) {
			inventory.stream().filter(x-> x.getProductName().trim().equalsIgnoreCase(p.getName())).forEach(x->{
				p.addStoreWhereInStock(x.getStoreName());
			});;
			
		}
		return products;
		
	}

	public boolean isSoldAtStores(String productName) {
		return productDAO.read(productName) != null;

	}

	public Product getProduct(String productName) {

		for (Product p : getAllProducts()) {
			if (p.getName().equalsIgnoreCase(productName))
				return p;
		}

		return null;
	}
}
