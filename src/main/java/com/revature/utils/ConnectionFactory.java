package com.revature.utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
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
		logger.log(LogLevel.INFO,"Inside Connection Factory");

		try {
			logger.log(LogLevel.INFO,"Trying to find PostgreSQL Driver");
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			logger.log(LogLevel.ERROR,"DRIVER COULD NOT BE FOUND");
		}

	}

	public Connection getConnection() {
		logger.log(LogLevel.INFO,"Attempting to get SQL connection object from PostgreSQL Driver");
		Connection conn = null;
		try {
			logger.log(LogLevel.INFO,"Attempting to retrieve information from database.properties file");
			properties.load(new FileReader("/Users/donato/Documents/workspace-spring-tool-suite-4-4.15.3.RELEASE/revPirate/src/main/resources/database/database.properties"));
		} catch (IOException e1) {
			
			logger.log(LogLevel.ERROR,"ATTEMPT TO RETRIEVE DATABASE CREDENTIALS IN FILE DATABASE.PROPERTIES FAILED");
		}
		try {
			conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
					properties.getProperty("password"));
			return conn;
		} catch (SQLException e) {
			logger.log(LogLevel.ERROR,"SQL EXCEPTION PREVENTED MAKING THE CONNECTION TO DATABASE");

		}
		return conn;
	}

	public static ConnectionFactory getInstance() {
		return new ConnectionFactory();
	}

}
