package com.main.StructuredSchedule.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.main.StructuredSchedule.models.Role;



public interface RoleRepository extends MongoRepository<Role, String> {
	
	public Role findByRole(String role);
	

}
