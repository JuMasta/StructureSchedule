package com.main.StructuredSchedule.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.main.StructuredSchedule.models.User;

public interface UsersRepository extends MongoRepository<User, String> {
	
	public User findByid(String id);
	
	public User findByemail(String email);

}
