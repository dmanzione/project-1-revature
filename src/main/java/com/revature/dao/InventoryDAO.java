package com.revature.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.InventoryItem;
import com.revature.utils.ConnectionFactory;

public class InventoryDAO {
	
	public List<InventoryItem> getAll() {
		List<InventoryItem> inventoryItem = new ArrayList<>();
		String query = "SELECT * FROM inventory";
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			InventoryItem item = null;
			while (rs.next()) {
				item = new InventoryItem(rs.getString("product_name"), rs.getInt("quantity"), rs.getString("store_location"));
				inventoryItem.add(item);
			}

			return inventoryItem;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return inventoryItem;
	}

}
