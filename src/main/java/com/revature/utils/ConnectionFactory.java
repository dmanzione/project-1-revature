package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.revature.utils.CaptainsLogger.LogLevel;

public class ConnectionFactory {
	private static CaptainsLogger logger = CaptainsLogger.getLogger();
	private static Properties properties = new Properties();

	private ConnectionFactory() {

	}

	static {
		logger.log(LogLevel.INFO, "Inside Connection Factory");

		try {
			logger.log(LogLevel.INFO, "Trying to find PostgreSQL Driver");
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			logger.log(LogLevel.ERROR, "DRIVER COULD NOT BE FOUND");
		}

	}

	public Connection getConnection() {
		logger.log(LogLevel.INFO, "Attempting to get SQL connection object from PostgreSQL Driver");
		Connection conn = null;
//		try {
//			logger.log(LogLevel.INFO, "Attempting to retrieve information from database.properties file");
//			properties.load(new FileReader(
//					"/Users/user/git/Donato-Manzione-P1-new/src/main/resources/database/database.properties"));
//		} catch (IOException e1) {
//
//			logger.log(LogLevel.ERROR, "ATTEMPT TO RETRIEVE DATABASE CREDENTIALS IN FILE DATABASE.PROPERTIES FAILED");
//		}
		try {
			conn = DriverManager.getConnection(
					"jdbc:postgresql://pirate-supply-store.cbvhz1czalox.us-east-1.rds.amazonaws.com:5432/pirate_supply_store",
					"dmanzione", "12345678");
			return conn;
		} catch (SQLException e) {
			logger.log(LogLevel.ERROR, "SQL EXCEPTION PREVENTED MAKING THE CONNECTION TO DATABASE");

		}

		logger.log(LogLevel.INFO, "SQL CONNECTION MADE SUCCESSFULLY");
		return conn;
	}

	public static ConnectionFactory getInstance() {
		return new ConnectionFactory();
	}

}
