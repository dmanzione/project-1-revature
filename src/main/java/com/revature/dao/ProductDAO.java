package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Product;
import com.revature.utils.ConnectionFactory;
import com.revature.utils.CaptainsLogger;
import com.revature.utils.CaptainsLogger.LogLevel;

public class ProductDAO {
	CaptainsLogger logger = CaptainsLogger.getLogger();
	
	public List<Product> readAll() {
		
		String query = "SELECT * FROM products";
		
		List<Product> products = new ArrayList<Product>();
		logger.log(LogLevel.INFO,"Inside the readAll method of the ProductDAO class");
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			Product product = null;
			while(rs.next()) {
				
				product = new Product(rs.getString("name"),rs.getDouble("price"),rs.getString("category"));
				products.add(product);
				
			}
			return products;
		} catch (SQLException e) {
		
			logger.log(LogLevel.ERROR,"Error while trying to retrieve list of products:\n\t\t"
					+ e.getMessage());
		}
		return products;
		
	}

	public Product read(String productName) {
		String query = "select * from products where name = '"+productName+"'";
		Product product = null;
		
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);	
			if(rs.next()) {
				product = new Product(rs.getString("name"),rs.getDouble("price"),rs.getString("category"));
				return product;
			}
			
		} catch (SQLException e) {
			
			logger.log(LogLevel.ERROR, "ERROR WHILE TRYING TO RETRIEVE PRODUCT RECORD:\n\t\t"+e.getMessage());
			return product;
		}
		
		return product;
	}
	
	
}
