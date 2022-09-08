package com.revature.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionFactory {
	private static Logger log = LogManager.getLogger(ConnectionFactory.class);
	private static Properties properties = new Properties();

	private ConnectionFactory() {

	}

	static {
		log.info("Inside Connection Factory");

		try {
			log.info("Trying to find PostgreSQL Driver");
			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {
			log.error("DRIVER COULD NOT BE FOUND", e);
		}

	}

	public Connection getConnection() {
		log.info("Attempting to get SQL connection object from PostgreSQL Driver");
		Connection conn = null;
		try {
			log.info("Attempting to retrieve information from database.properties file");
			properties.load(new FileInputStream("/Users/donato/Documents/workspace-spring-tool-suite-4-4.15.3.RELEASE/revPirate/src/main/resources/database/database.properties"));
		} catch (IOException e1) {
			
			log.error("ATTEMPT TO RETRIEVE DATABASE CREDENTIALS IN FILE DATABASE.PROPERTIES FAILED" , e1);
		}
		try {
			conn = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
					properties.getProperty("password"));
			return conn;
		} catch (SQLException e) {
			log.error("SQL EXCEPTION PREVENTED MAKING THE CONNECTION TO DATABASE", e);

		}
		return conn;
	}

	public static ConnectionFactory getInstance() {
		return new ConnectionFactory();
	}

}
