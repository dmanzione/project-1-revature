package com.revature.utils;

public class Templates {

	public static String getHeader() {
		return  "<!DOCTYPE html>\n" + "<html>\n" + "<title>The Pirate Store Chain</title>\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + "\n"
				+ "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" + "\n" + "\n"
				+ "<div class=\"w3-brown w3-container w3-center\"><h1 \n"
				+ "class=\"w3-main\"><br>Welcome to the Pirate Supply \n" + "Store!</h1><br><br><br></div>\n" + "";

	}
	
	public static String getFooter() {
		return 	"<div class=\"w3-third\"><br></div><div class=\"w3-half\">\n" + "\n" + "</div>\n" + "\n" + "\n"
				+ "</div>\n" + "\n" + "\n" + "</body>\n" + "</html>\n" + "";

	}
	
}
