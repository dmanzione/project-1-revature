package com.revature.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Order;
import com.revature.utils.ConnectionFactory;

public class OrderDAO {

	public boolean create(Order order) {

		return false;

	}

	public List<Order> readAll() {
		String query = "SELECT * FROM orders";
		List<Order> orders = new ArrayList<Order>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				Order order = new Order(rs.getString("store_location"), rs.getInt("pirate_id"),
						rs.getDouble("total_price"));
				order.setId(rs.getInt("id"));
				orders.add(order);
			}

			return orders;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return orders;
	}
}
