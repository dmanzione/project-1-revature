package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Pirate;
import com.revature.utils.CaptainsLogger;
import com.revature.utils.CaptainsLogger.LogLevel;
import com.revature.utils.ConnectionFactory;

public class PirateDAO {
	CaptainsLogger logger = CaptainsLogger.getLogger();

	public List<Pirate> getAllInstances() {
		String query = "SELECT * FROM pirates;";
		List<Pirate> pirates = new ArrayList<>();
		logger.log(LogLevel.INFO, "Inside getAllInstances method of PirateDAO class");
		ConnectionFactory.getInstance();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			Pirate pirate = null;
			while (rs.next()) {
				pirate = new Pirate(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"),
						rs.getString("password"));
				pirate.setId(rs.getInt("id"));
				pirates.add(pirate);
			}
			return pirates;
		} catch (SQLException e) {

			logger.log(LogLevel.ERROR, "UNABLE TO RETRIEVE RECORDS OF PIRATES");
			return pirates;
		}
	}

	public boolean create(Pirate pirate) {
		logger.log(LogLevel.INFO, "Inside of the create method of the PirateDAO class");

		String query = "INSERT INTO pirates (first_name, last_name, email, password) VALUES (?,?,?,?);";

		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, pirate.getFirstName());
			pstmt.setString(2, pirate.getLastName());
			pstmt.setString(3, pirate.getEmail());
			pstmt.setString(4, pirate.getPassword());
			pstmt.execute();

		} catch (SQLException e) {

			logger.log(LogLevel.ERROR,
					"ERROR WHILE TRYING TO ADD A PIRATE RECORD TO DATABASE FROM DAO " + "\n \t" + e.getMessage());
			return false;
		}
		return true;
	}

	public Pirate readBy(String email) {
		String query = "SELECT * FROM pirates WHERE email = '" + email + "'";
		Pirate pirate = null;
		logger.log(LogLevel.INFO, "Inside readBy(emai) method of PirateDAO class");
		ConnectionFactory.getInstance();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				pirate = new Pirate(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"),
						rs.getString("password"));
				pirate.setId(rs.getInt("id"));
				return pirate;
			}

		} catch (SQLException e) {

			logger.log(LogLevel.INFO, "UNABLE TO RETRIEVE PIRATE RECORD");

		}
		return pirate;
	}

}
