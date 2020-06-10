package com.main.StructuredSchedule.services;

import com.main.StructuredSchedule.models.Request;

public   interface  RequestService {
	
	
	public Request findById(String id);
	
	public Request createRequest(Request t);
	
	public Request updateRequest(Request t);
	
	public String deleteRequest(Request t);

}
