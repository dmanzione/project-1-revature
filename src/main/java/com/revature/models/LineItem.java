package com.revature.models;

public class LineItem {

	private String productName;
	private int quantity;

	
	public LineItem(String productName, int quantity) {
		super();
		this.productName = productName;
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "LineItem [productName=" + productName + ", quantity=" + quantity + "]";
	}

	

}
