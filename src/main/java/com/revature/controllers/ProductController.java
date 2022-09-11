package com.revature.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ProductDAO;
import com.revature.models.Product;
import com.revature.services.ProductService;

public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ProductService productService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		productService = new ProductService(new ProductDAO());
		resp.setStatus(200);
		resp.setContentType("application/json");
		List<Product> products = productService.getAllProducts();
		ObjectMapper mapper = new ObjectMapper();
		String fullPage = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
		resp.getWriter().write(fullPage);

	
	}

	private void goPost() {

	}
}
