package com.jwt.test.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.test.dto.request.Signin;
import com.jwt.test.dto.request.Signupdto;
import com.jwt.test.dto.response.JwtResponse;
import com.jwt.test.security.jwt.JwtUtils;
import com.jwt.test.service.UserService;
import com.jwt.test.serviceImpl.UserDetailsImpl;

@RestController
@RequestMapping("/api/auth")
public class EnrollmentController {
	
	 @Autowired
	  AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	
	  @Autowired
	  JwtUtils jwtUtils;

	  @PostMapping("/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody Signin signin) {

	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(signin.getUsername(), signin.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    String jwt = jwtUtils.generateJwtToken(authentication);
	    
	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
	

	    return ResponseEntity.ok(new JwtResponse(jwt, 
	                         userDetails.getId(), 
	                         userDetails.getUsername(), 
	                         userDetails.getEmail(), 
	                         userDetails.getRole()));   
	  }
	
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> register(@RequestBody Signupdto signupdto) {
		return userService.enrollment(signupdto);
	}
	
}
