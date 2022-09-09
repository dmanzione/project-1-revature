package com.revature.services;

import java.util.List;

import com.revature.dao.ProductDAO;
import com.revature.models.Product;

public class ProductService {

	private ProductDAO productDAO;

	public ProductService(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public List<Product> getAllProducts() {

		return productDAO.readAll();
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
