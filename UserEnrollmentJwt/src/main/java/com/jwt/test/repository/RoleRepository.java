package com.jwt.test.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.test.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	public Role findByRole(String role);

}
