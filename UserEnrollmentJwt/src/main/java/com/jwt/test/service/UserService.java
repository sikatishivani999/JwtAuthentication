package com.jwt.test.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.jwt.test.dto.request.Signupdto;

@Component
public interface UserService {
	
	public ResponseEntity<?> enrollment(Signupdto signupdto);

}
