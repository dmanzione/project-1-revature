package com.revature.models;

import java.util.List;

public class Order {
	private int id;
	private List<LineItem> lineItems;
	private String storeLocation;
	private int pirateID;
	private double totalPrice;

	public Order(String storeLocation, int pirateID) {
		this.storeLocation = storeLocation;
		this.pirateID = pirateID;
	}

	public Order(String storeLocation, int pirateID, double totalPrice) {
		this.storeLocation = storeLocation;
		this.pirateID = pirateID;
		this.setTotalPrice(totalPrice);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", lineItems=" + lineItems + ", storeLocation=" + storeLocation + ", pirateID="
				+ pirateID + "]";
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public String getStoreLocation() {
		return storeLocation;
	}

	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}

	public int getPirateID() {
		return pirateID;
	}

	public void setPirateID(int pirateID) {
		this.pirateID = pirateID;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
