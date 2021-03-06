package com.main.StructuredSchedule.models;


import java.util.List;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.main.StructuredSchedule.Enums.UserType;

@Document("users")
public class User {
	
	@Id
	private String id;
	
	@Indexed(unique = true, direction = IndexDirection.DESCENDING)
	private  String phoneNumber;
	
	private String password;
	
	
	private String name;
	
	private String activationUri;
	
	private String activationCode;
	
	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public String getActivationUri() {
		return activationUri;
	}

	public void setActivationUri(String activationUri) {
		this.activationUri = activationUri;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@DBRef
	List<Record> records;
	
	private UserType userType;



	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}


	

	public User() {
		super();
	}

	public User(String phoneNumber,String password) {
		super();
		
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	@DBRef
	private Set<Role> roles;
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phonNumber) {
		this.phoneNumber = phonNumber;
	}

}
