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
				+ "<form class=\"w3-container w3-sand w3-card-4 w3-margin w3-light-brown \" action=\"/register\" method=\"post\"> "
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
				+ "  <form class=\"w3-container w3-sand w3-card-4 w3-margin w3-light-brown \" action=\"/login\" method=\"post\">\n"
				+ "    <h2 class=\"w3-text-brown\">Log in</h2>\n"
				+ "    <p> <label class=\"w3-text-brown\"><b>Email</b></label> <input class=\"w3-input w3-border\" name=\"email\" type=\"email\" required></p>\n"
				+ "    <p> <label class=\"w3-text-brown\"><b>Password</b></label> <input class=\"w3-input w3-border\" name=\"password\" type=\"password\" required></p>\n"
				+ "    <p> <input type=\"submit\" value=\"submit\" class=\"w3-btn w3-brown\"></p>\n" + "  </form>";
	}

	public static String getHome() {
	
		return "<title>The Pirate Store Chain</title>\n"
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
				+ "        <span class=\"w3-bar-item w3-margin-right \">Home: <span class=\"w3-codespan w3-text-black\"> GET /</span></span>\n"
				+ "\n"
				+ "        <span class=\"w3-bar-item w3-margin-right \">Locations: <span class=\"w3-codespan w3-text-black\"> GET /stores</span>\n"
				+ "        </span>\n"
				+ "        <span class=\"w3-bar-item w3-margin-right \">Login Page: <span class=\"w3-codespan w3-text-black\"> GET /login</span>\n"
				+ "        </span>\n"
				+ "        <span class=\"w3-bar-item w3-margin-right \">Signup Page: <span class=\"w3-codespan w3-text-black\"> GET /register</span>\n"
				+ "        </span>\n" + "      </div>\n" + "     \n"
				+ "        <h5 class=\"w3-left w3-bar-item\">Pirate endpoints:</h5>\n" + "\n"
				+ "        <div class=\"w3-container w3-padding w3-bar-block\">\n"
				+ "          <span class=\"w3-bar-item w3-margin-right \">Submit registration form: <span class=\"w3-codespan w3-text-black\"> POST /register</span>\n"
				+ "          </span>\n"
				+ "          <span class=\"w3-bar-item w3-margin-right \">Submit login form form: <span class=\"w3-codespan w3-text-black\"> POST /register</span>\n"
				+ "          </span>\n"
				+ "          <span class=\"w3-bar-item w3-margin-right \">View past orders: <span class=\"w3-codespan w3-text-black\">/orders</span>\n"
				+ "          </span>\n" + "          </span>\n" + "        </div>\n" + "  \n"
				+ "          <h5 class=\"w3-bar-item\">Employee endpoints:</h5>\n"
				+ "<div class=\"w3-container w3-padding w3-bar-block\">\n" + "         \n" + "\n"
				+ "          <span class=\"w3-bar-item w3-margin-right \">See inventory for a location: <span class=\"w3-codespan w3-text-black\">GET /inventory</span></span>\n"
				+ "          \n" + "\n"
				+ "          <span class=\"w3-bar-item w3-margin-right \">All pirate clients: <span class=\"w3-codespan w3-text-black\">GET /pirates</span>\n"
				+ "          </span><span class=\"w3-bar-item w3-margin-right \">All orders: <span class=\"w3-codespan w3-text-black\">GET /orders</span>\n"
				+ "          </span>\n"
				+ "          </span><span class=\"w3-bar-item w3-margin-right \">Replenish inventory for a location:<span class=\"w3-codespan w3-text-black\"> POST /inventory</span>\n"
				+ "          </span>\n" + "\n" + "        </div>\n" + "      </div>\n" + "      <br>\n" + "\n"
				+ "      <br><br>\n" + "      <br><br>\n" + "</body>";
	}

	public static String getError() {
		return "<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "</head>\n"
				+ "<title>The Pirate Store Chain</title>\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
				+ "\n"
				+ "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<title>Error | Pirate Chain Store</title>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "	<div class=\"w3-brown w3-container w3-center\">\n"
				+ "		<h1 class=\"w3-main w3-red w3-card\">\n"
				+ "			<br>ERROR PAGE\n"
				+ "		</h1>\n"
				+ "		<br>\n"
				+ "		<br>\n"
				+ "		<br>\n"
				+ "	</div>\n"
				+ "\n"
				+ "	<div class=\"w3-sand  w3-container\"\n"
				+ "		style=\"word-wrap: break-word; white-space: pre-wrap; line-height: 1.8\">\n"
				+ "\n"
				+ "		<div class=\"w3-third\">\n"
				+ "			<br>\n"
				+ "		</div>\n"
				+ "		<div class=\"w3-half\"></div>\n"
				+ "\n"
				+ "\n"
				+ "	</div>\n"
				+ "\n"
				+ "\n"
				+ "</body>\n"
				+ "</html>\n"
				;
	}

}
