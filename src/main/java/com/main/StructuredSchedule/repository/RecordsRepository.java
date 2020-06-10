package com.main.StructuredSchedule.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.main.StructuredSchedule.models.Record;




public interface RecordsRepository extends MongoRepository<Record, String> {

		public Record findByid(String id);
		
		
	
	
}
