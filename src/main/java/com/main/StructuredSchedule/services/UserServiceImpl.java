package com.main.StructuredSchedule.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.StructuredSchedule.models.Record;
import com.main.StructuredSchedule.models.User;
import com.main.StructuredSchedule.repository.UsersRepository;


@Service
public class UserServiceImpl implements UserService {
	
	
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
	public User findByEmail(String email) {
		return userRepository.findByemail(email);
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
