package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Pirate;
import com.revature.utils.ConnectionFactory;

public class PirateDAO {
	Logger log = LogManager.getLogger(PirateDAO.class);

	public List<Pirate> getAllInstances() {
		String query = "SELECT * FROM pirates;";
		List<Pirate> pirates = new ArrayList<>();
		log.info("Inside getAllInstances method of PirateDAO class");
		ConnectionFactory.getInstance();
		try (Connection conn = ConnectionFactory.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			Pirate pirate = null;
			while (rs.next()) {
				pirate = new Pirate(rs.getString("first_name") + rs.getString("last_name"), rs.getString("email"),
						rs.getString("password"));
				pirates.add(pirate);
			}
			return pirates;
		} catch (SQLException e) {

			log.error("UNABLE TO RETRIEVE RECORDS OF PIRATES", e);
			return pirates;
		}
	}
}
