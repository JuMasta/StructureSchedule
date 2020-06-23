package com.main.StructuredSchedule.dto;

import com.main.StructuredSchedule.models.User;

public class UserDTO {

	private String id;
	
	private  String phoneNumber;
	
	private String name;
	
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public UserDTO(User user)
	{
		this.id = user.getId();
		this.phoneNumber = user.getPhoneNumber();
		this.name = user.getName();
		
		
	}
	public UserDTO() {
		
		
	}

	public String getPassword() {
		
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
		
	}

}
	

