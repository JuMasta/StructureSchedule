package com.main.StructuredSchedule.services;

import com.main.StructuredSchedule.models.Record;



public interface RecordService {

	public Record saveRecord(Record record);
	
	
	public Record findById(String id);
	
	
}
