package com.main.StructuredSchedule.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.StructuredSchedule.models.Record;
import com.main.StructuredSchedule.models.Request;
import com.main.StructuredSchedule.repository.RequestRepository;

@Service
public class RequestServiceImpl implements  RequestService {
	
	
	@Autowired
	RequestRepository requestRepositury;



	@Override
	public Request findById(String id) {
		
		return requestRepositury.findByid(id);
	}

	@Override
	public Request createRequest(Request t) {
		// TODO Auto-generated method stub
		return requestRepositury.save(t);
	}

	
	@Override
	public Request updateRequest(Request req) {
		
		
		
		return requestRepositury.save(req);
	}
	
	
	@Override
	public String deleteRequest(Request req) {
		requestRepositury.delete(req);
		return "success";
	}

}
