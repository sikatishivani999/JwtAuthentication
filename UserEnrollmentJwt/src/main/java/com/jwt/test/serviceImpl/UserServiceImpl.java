package com.jwt.test.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jwt.test.dto.request.Signupdto;
import com.jwt.test.dto.response.MessageResponse;
import com.jwt.test.model.Role;
import com.jwt.test.model.User;
import com.jwt.test.repository.RoleRepository;
import com.jwt.test.repository.UserRepository;
import com.jwt.test.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepo;

	@Override
//	public String enrollment(Signupdto signupdto) {
//		// TODO Auto-generated method stub
//		if(userRepo.existsByUsername(signupdto.getUsername())) {
//			return "user already exists!!";
//		}
//		
//		User user = new User();
//		
//		user.setUsername(signupdto.getUsername());
//		user.setEmail(signupdto.getEmail());
//		user.setPassword(passwordEncoder.encode(signupdto.getPassword()));
//		Role role = roleRepository.findByRole(signupdto.getRole());
//		user.setRole(new Role(role.getId()));
//		
//		userRepo.save(user);
//		return "user registered successfully!!";
//	}
	
	public ResponseEntity<?> enrollment(@Valid @RequestBody Signupdto signupdto) {
	    if (userRepo.existsByUsername(signupdto.getUsername())) {
	      return ResponseEntity
	          .badRequest()
	          .body(new MessageResponse("Error: Username is already taken!"));
	    }

	    if (userRepo.existsByEmail(signupdto.getEmail())) {
	      return ResponseEntity
	          .badRequest()
	          .body(new MessageResponse("Error: Email is already in use!"));
	    }

	    User user = new User();
	
		user.setUsername(signupdto.getUsername());
		user.setEmail(signupdto.getEmail());
		user.setPassword(passwordEncoder.encode(signupdto.getPassword()));
		Role role = roleRepository.findByRole(signupdto.getRole());
		user.setRole(new Role(role.getId()));

	
	    userRepo.save(user);

	    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	  }

}
