package com.revature.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setStatus(200);

		resp.setContentType("text/html");
		resp.getWriter().write("<title>The Pirate Store Chain</title>\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + "\n"
				+ "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" + "\n"
				+ "<body class=\"w3-sand\">\n" + "\n" + "  <!--header-->\n"
				+ "  <header class=\"w3-brown w3-container w3-center\">\n"
				+ "    <h1 class=\"\"><br>Welcome to the Pirate Supply\n" + "      Store API!</h1><br><br><br>\n"
				+ "  </header>\n" + "\n" + "  <br><br><br>\n" + "\n" + "  <!--main, display container -->\n"
				+ "  <div class=\"w3-main w3-display-container\">\n" + "\n"
				+ "    <div class=\"w3-half w3-display-topmiddle w3-card-4  w3-light-grey w3-padding w3-threequarter \">\n"
				+ "      <div class=\"w3-container w3-padding w3-bar-block\">\n" + "        \n"
				+ "        <h5 class=\"w3-left w3-bar-item \">Public endpoints:</h5>\n"
				+ "<div class=\"w3-container w3-padding w3-bar-block\">\n"
				+ "        <span class=\"w3-bar-item w3-margin-right \">Home: <span class=\"w3-codespan w3-text-black\"> GET /revpirates/</span></span>\n"
				+ "\n"
				+ "        <span class=\"w3-bar-item w3-margin-right \">Locations: <span class=\"w3-codespan w3-text-black\"> GET /revpirates/stores</span>\n"
				+ "        </span>\n"
				+ "        <span class=\"w3-bar-item w3-margin-right \">Login Page: <span class=\"w3-codespan w3-text-black\"> GET /revpirates/login</span>\n"
				+ "        </span>\n"
				+ "        <span class=\"w3-bar-item w3-margin-right \">Signup Page: <span class=\"w3-codespan w3-text-black\"> GET /revpirates/register</span>\n"
				+ "        </span>\n" + "      </div>\n" + "     \n"
				+ "        <h5 class=\"w3-left w3-bar-item\">Pirate endpoints:</h5>\n" + "\n"
				+ "        <div class=\"w3-container w3-padding w3-bar-block\">\n"
				+ "          <span class=\"w3-bar-item w3-margin-right \">Submit registration form: <span class=\"w3-codespan w3-text-black\"> POST /revpirates/register</span>\n"
				+ "          </span>\n"
				+ "          <span class=\"w3-bar-item w3-margin-right \">Submit login form form: <span class=\"w3-codespan w3-text-black\"> POST /revpirates/register</span>\n"
				+ "          </span>\n"
				+ "          <span class=\"w3-bar-item w3-margin-right \">View past orders: <span class=\"w3-codespan w3-text-black\">/revpirates/orders</span>\n"
				+ "          </span>\n" + "          </span>\n" + "        </div>\n" + "  \n"
				+ "          <h5 class=\"w3-bar-item\">Employee endpoints:</h5>\n"
				+ "<div class=\"w3-container w3-padding w3-bar-block\">\n" + "         \n" + "\n"
				+ "          <span class=\"w3-bar-item w3-margin-right \">See inventory for a location: <span class=\"w3-codespan w3-text-black\">GET /revpirates/stores/{location}/inventory</span></span>\n"
				+ "          \n" + "\n"
				+ "          <span class=\"w3-bar-item w3-margin-right \">All pirate clients: <span class=\"w3-codespan w3-text-black\">GET /revpirates/pirates</span>\n"
				+ "          </span><span class=\"w3-bar-item w3-margin-right \">All orders: <span class=\"w3-codespan w3-text-black\">GET /revpirates/orders</span>\n"
				+ "          </span>\n"
				+ "          </span><span class=\"w3-bar-item w3-margin-right \">Replenish inventory for a location:<span class=\"w3-codespan w3-text-black\"> POST /revpirates/stores/{location}/inventory</span>\n"
				+ "          </span>\n" + "\n" + "        </div>\n" + "      </div>\n" + "      <br>\n" + "\n"
				+ "      <br><br>\n" + "      <br><br>\n" + "</body>");

	}

}
