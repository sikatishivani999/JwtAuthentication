package com.jwt.test.dto.request;

public class Signin {
	
	private String username;
	
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Signin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Signin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Signin [username=" + username + ", password=" + password + "]";
	}
	
	

}
