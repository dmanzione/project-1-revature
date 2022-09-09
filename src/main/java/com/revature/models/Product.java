package com.revature.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DonatoManzione
 * 
 *         This class represents a product; you can only have one.
 * 
 *         you can have an inventory object that represents the quantity of this
 *         object in a store, but you cannot have two objects of this class --
 *         that would be a duplicate entry See @Inventory
 *
 */
public class Product {

	private String name;
	private double price;
	private String category;

	public enum categories {
		CLOTHING_AND_ACCESSORIES, NAVIGATION, HOw_TO_GUIDES, MAGIC_TOKENS_AND_POTIONS, ENTERTAINMENT, WEAPONRY,
		MISCELLANEOUS

	}

	private List<String> inStockAt = new ArrayList<String>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product(String name, double price, String category) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public Product() {

	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<String> getStoresInStockAt() {
		return inStockAt;
	}

	public void addStoreWhereInStock(List<String> inStockAt) {
		this.inStockAt = inStockAt;
	}
}
