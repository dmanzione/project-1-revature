package com.revature.models;

public class Admin {

	@Override
	public String toString() {
		return "Admin [name=" + name + ", password=" + password + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	private String name;
	private String password;
}
