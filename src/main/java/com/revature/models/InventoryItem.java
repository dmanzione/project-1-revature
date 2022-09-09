package com.revature.models;

public class InventoryItem {
	private String productName;
	private int quantity;
	private String storeName;

	public InventoryItem(String productName, int quantity, String storeName) {
		super();
		this.productName = productName;
		this.quantity = quantity;
		this.storeName = storeName;
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
		return "InventoryItem [productName=" + productName + ", quantity=" + quantity + ", storeName=" + storeName
				+ "]";
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
}
