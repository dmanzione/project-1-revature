package com.revature.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Order;
import com.revature.utils.ConnectionFactory;
import com.revature.utils.CaptainsLogger;
import com.revature.utils.CaptainsLogger.LogLevel;

public class OrderDAO {
	CaptainsLogger logger = CaptainsLogger.getLogger();
	
	public static void main(String[] args) {
		
		new OrderDAO().create(new Order("Captain Branch",6,160.00));
	}
	public boolean create(Order order) {
			
		String query = "INSERT INTO orders (pirate_id, store_location, total_price) values(?,?,?)";
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,order.getPirateID());
			pstmt.setString(2, order.getStoreLocation());
			pstmt.setDouble(3, order.getTotalPrice());
			
			pstmt.execute();
			
			return true;
			
		} catch (SQLException e) {
			
			logger.log(LogLevel.ERROR, "Error while trying to add an order "+order+ "to database:\n\t\t"+e.getMessage());
			return false;
		}

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
