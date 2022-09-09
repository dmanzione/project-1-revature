package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.LineItem;
import com.revature.utils.CaptainsLogger;
import com.revature.utils.CaptainsLogger.LogLevel;
import com.revature.utils.ConnectionFactory;

public class LineItemDAO {
	CaptainsLogger logger = CaptainsLogger.getLogger();

	public boolean create(LineItem li) {

		String query = "INSERT INTO line_items (product_name, quantity,store_location) values (?,?,?)";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, li.getProductName());
			pstmt.setInt(2, li.getQuantity());
			pstmt.setString(3, li.getStoreLocation());

			pstmt.execute();

			return true;

		} catch (SQLException e) {

			logger.log(LogLevel.ERROR, "Error while trying to add lineitem record to database");
			return false;
		}

	}

}
