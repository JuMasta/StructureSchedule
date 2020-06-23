package com.main.StructuredSchedule.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.StructuredSchedule.models.Record;
import com.main.StructuredSchedule.models.User;
import com.main.StructuredSchedule.repository.UsersRepository;


@Service
public class UserServiceImpl implements UserService {
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UsersRepository userRepository;

	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User findById(String id) {
	
		return userRepository.findByid(id);

	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByPhoneNumber(String phoneNumber) {
		return userRepository.findByphoneNumber(phoneNumber);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	
	@Override
	public boolean activateUser(String uri, String code) {
		User user = userRepository.findByActivationUri(uri);
		if (user == null)
			return false;
		if (!user.getActivationCode().equals(code))
			return false;
		user.setActivationCode(null);
		user.setActivationUri(null);
		userRepository.save(user);
		
		
		return true;
		
	}

}
