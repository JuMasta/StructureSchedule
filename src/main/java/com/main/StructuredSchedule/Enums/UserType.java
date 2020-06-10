package com.main.StructuredSchedule.Enums;

public enum UserType {
	
	PRODUCER("Producer"),
	CONSUMER("Consumer");
	
	private String role;
	
	UserType(String role)
	{
		this.role = role;
		
	}
	
	public String getRole() {
		
		return role;
	}

}
