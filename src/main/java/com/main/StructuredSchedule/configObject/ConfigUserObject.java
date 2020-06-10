package com.main.StructuredSchedule.configObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.main.StructuredSchedule.Enums.UserType;
import com.main.StructuredSchedule.dto.UserDTO;
import com.main.StructuredSchedule.models.Record;
import com.main.StructuredSchedule.models.Role;
import com.main.StructuredSchedule.models.User;
import com.main.StructuredSchedule.repository.RoleRepository;
import com.main.StructuredSchedule.services.UserServiceImpl;




@Service
public class ConfigUserObject  {
	
	Logger logger = LoggerFactory.getLogger(ConfigUserObject.class);
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserServiceImpl userService;
	
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	public User configObjectForCreate(UserDTO userDTO,UserType userType) {
		Role role = roleRepository.findByRole(userType.getRole());
		User user = new User();
		user.setRecords(new ArrayList<Record>());
		user.setRoles(new HashSet<>(Arrays.asList(role)));
		user.setUserType(userType);
		user.setEmail(userDTO.getEmail());
		user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
		user.setName(userDTO.getName());
		
		return user;
		
	}
	
	public User configObjectByRecord(User user,Record record)
	{
		
		List<Record> records =  user.getRecords();
		records.add(record);
		return user;
	}

	public User configObjectForUpdate(UserDTO userDTO)  {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();		
		User user = userService.findByEmail(currentPrincipalName);
		if(userDTO.getName() != null)
			user.setName(userDTO.getName());
		return user;
	}

}
