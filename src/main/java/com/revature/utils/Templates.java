package com.revature.utils;

public class Templates {

	public static String getFooter() {
		return "<div class=\"w3-third\"><br></div><div class=\"w3-half\">\n" + "\n" + "</div>\n" + "\n" + "\n"
				+ "</div>\n" + "\n" + "\n" + "</body>\n" + "</html>\n" + "";

	}

	public static String getHeader() {
		return "<!DOCTYPE html>\n" + "<html>\n" + "<title>The Pirate Store Chain</title>\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + "\n"
				+ "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" + "\n" + "\n"
				+ "<div class=\"w3-brown w3-container w3-center\">" + "<h1><br>Welcome to the Pirate Supply \n"
				+ "Store!</h1><br><br><br></div>\n" + "";

	}

	public static String getSignupPage() {

		return "<!DOCTYPE html>" + "<html class=\"\">" + "<title>Register | Pirate Supply Store</title>"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
				+ "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">" + "<body>"
				// form
				+ "<form class=\"w3-container w3-sand w3-card-4 w3-margin w3-light-brown \" action=\"/revPirate/register\" method=\"post\"> "
				+ "<h2 class=\"w3-text-brown\">Register</h2> <p>"
				+ "<label class=\"w3-text-brown\"><b>First Name</b></label>"
				+ " <input class=\"w3-input w3-border\" name=\"firstName\" type=\"text\" required></p> <p>"
				+ " <label class=\"w3-text-brown\"><b>Last Name</b></label> "

				+ "<input class=\"w3-input w3-border\" name=\"lastName\" type=\"text\" required></p> "
				+ "<p> <label class=\"w3-text-brown\"><b>Email</b></label> "
				+ "<input class=\"w3-input w3-border\" name=\"email\" type=\"email\" required></p> <p>"
				+ "<label class=\"w3-text-brown\"><b>Password</b></label>"
				+ "<input class=\"w3-input w3-border\" name=\"password\" type=\"password\" minlength='8' maxlength='8'required></p> <p>     "
				+ "<input type=\"submit\" value=\"register\" class=\"w3-btn w3-brown\"></p>" + "</form>" + "</body>"
				+ "</html> \"";
	}

	public static String getLoginPage() {
		return "<!DOCTYPE html>\n" + "<html class=\"\">\n" + "<title>Log In | Pirate Supply Store</title>\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
				+ "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" + "\n" + "<body>\n"
				+ "  <form class=\"w3-container w3-sand w3-card-4 w3-margin w3-light-brown \" action=\"/revPirate/login\" method=\"post\">\n"
				+ "    <h2 class=\"w3-text-brown\">Log in</h2>\n"
				+ "    <p> <label class=\"w3-text-brown\"><b>Email</b></label> <input class=\"w3-input w3-border\" name=\"email\" type=\"email\" required></p>\n"
				+ "    <p> <label class=\"w3-text-brown\"><b>Password</b></label> <input class=\"w3-input w3-border\" name=\"password\" type=\"password\" required></p>\n"
				+ "    <p> <input type=\"submit\" value=\"submit\" class=\"w3-btn w3-brown\"></p>\n" + "  </form>";
	}

}
