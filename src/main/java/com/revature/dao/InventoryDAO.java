package com.revature.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.InventoryItem;
import com.revature.utils.CaptainsLogger;
import com.revature.utils.CaptainsLogger.LogLevel;
import com.revature.utils.ConnectionFactory;

public class InventoryDAO {
	CaptainsLogger logger = CaptainsLogger.getLogger();

	public List<InventoryItem> getAll() {
		List<InventoryItem> inventoryItem = new ArrayList<>();
		String query = "SELECT * FROM inventory";
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(query);
			InventoryItem item = null;
			while (rs.next()) {
				item = new InventoryItem(rs.getString("product_name"), rs.getInt("quantity"),
						rs.getString("store_location"));
				inventoryItem.add(item);
			}

			return inventoryItem;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return inventoryItem;
	}

	public boolean update(InventoryItem ii) {
		String query = "update inventory set quantity = ? where store_location = ? and product_name = ?";
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, ii.getQuantity());
			pstmt.setString(2, ii.getStoreName());
			pstmt.setString(3, ii.getProductName());

			pstmt.execute();
			return true;

		} catch (SQLException e) {
			logger.log(LogLevel.ERROR, "ERROR WHILE TRYING TO UPDATE INVENTORY:\n\t\t" + e.getMessage());
			return false;
		}

	}

}
