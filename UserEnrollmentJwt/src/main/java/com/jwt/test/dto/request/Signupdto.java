package com.jwt.test.dto.request;

import java.util.Set;

public class Signupdto {
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Signupdto(String username, String email, String password, String role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Signupdto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Signupdto [username=" + username + ", email=" + email + ", password=" + password + ", role=" + role
				+ "]";
	}

	
}
