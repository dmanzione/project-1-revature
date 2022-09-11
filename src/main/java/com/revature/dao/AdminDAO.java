package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Admin;
import com.revature.models.Pirate;
import com.revature.utils.ConnectionFactory;
import com.revature.utils.CaptainsLogger;
import com.revature.utils.CaptainsLogger.LogLevel;

public class AdminDAO {

	private CaptainsLogger logger = CaptainsLogger.getLogger();

	public Admin read(String name) {
		
		String query = "SELECT * FROM employees WHERE name = '" + name + "'";
		Admin admin = null;
		logger .log(LogLevel.INFO, "Inside readBy(name) method of AdminDAO class");
		ConnectionFactory.getInstance();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				admin = new Admin(rs.getString("name"), rs.getString("password"));
				
				return admin;
			}

		} catch (SQLException e) {

			logger.log(LogLevel.INFO, "UNABLE TO RETRIEVE PIRATE RECORD");

		}
		return admin;
	}

}
