package com.revature.services;

import com.revature.models.Product;
import com.revature.dao.LineItemDAO;
import com.revature.dao.ProductDAO;
import com.revature.models.LineItem;

public class LineItemService {
	private LineItemDAO lineItemDAO;

	public LineItemService(LineItemDAO lineItemDAO) {
		this.lineItemDAO = lineItemDAO;
	}

	public boolean submitForPurchase(LineItem li) {

		return lineItemDAO.create(li);
	}

	public double getTotalPrice(LineItem lineItem) {
		String productName = lineItem.getProductName();
		ProductService productService = new ProductService(new ProductDAO());
		Product product = productService.getProduct(productName);
		return product.getPrice() * lineItem.getQuantity();
	}
}
