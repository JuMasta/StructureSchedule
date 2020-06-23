package com.main.StructuredSchedule.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.main.StructuredSchedule.models.Role;
import com.main.StructuredSchedule.models.User;




@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	UserServiceImpl userService;
	

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByPhoneNumber(username);	
		List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
		logger.info(user.getRoles().iterator().next().getRole());
		return new org.springframework.security.core.userdetails.User(user.getPhoneNumber(), user.getPassword(), authorities);
		
	}
	
	
	public List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
	    Set<GrantedAuthority> roles = new HashSet<>();
	    userRoles.forEach((role) -> {
	        roles.add(new SimpleGrantedAuthority(role.getRole()));
	    });

	    List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
	    return grantedAuthorities;
	    
	}

}
