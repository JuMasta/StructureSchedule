package com.main.StructuredSchedule.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.main.StructuredSchedule.models.Request;

public interface RequestRepository extends MongoRepository<Request, String> {
	
	public Request findByid(String id);

}
