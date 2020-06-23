package com.main.StructuredSchedule.services;

import com.main.StructuredSchedule.models.User;


public interface UserService {
	
	
	public User createUser(User user);
	
	public  User saveUser(User user);
	
	
	public User findById(String id);
	
	public User findByPhoneNumber(String phoneNumber);

	

	boolean activateUser(String uri,String code);
	

}
