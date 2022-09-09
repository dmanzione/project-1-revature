package com.revature.models;

public class Pirate {
	private String email;

	private int id;
	private String firstName;

	private String lastName;
	private String password;

	public Pirate(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;

	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Pirate [name=" + firstName + " " + lastName + ", email=" + email + "]";
	}

	@Override
	public boolean equals(Object o) {
		Pirate other = (Pirate) o;
		return other.getEmail().equalsIgnoreCase(email) && other.getFirstName().equalsIgnoreCase(firstName)
				&& other.getFirstName().equalsIgnoreCase(firstName) && other.getPassword().equalsIgnoreCase(password);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
