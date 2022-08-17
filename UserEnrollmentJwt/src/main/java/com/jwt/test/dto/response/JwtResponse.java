package com.jwt.test.dto.response;

import java.util.List;

import com.jwt.test.model.Role;

public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Long id;
  private String username;
  private String email;
  private Role roles;

  public JwtResponse(String accessToken, Long id, String username, String email, Role role) {
    this.token = accessToken;
    this.id = id;
    this.username = username;
    this.email = email;
    this.roles = role;
  }

  public JwtResponse(String jwt) {
	// TODO Auto-generated constructor stub
}

public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Role getRoles() {
    return roles;
  }
}
