package com.main.StructuredSchedule.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.main.StructuredSchedule.models.Record;
import com.main.StructuredSchedule.repository.RecordsRepository;


@Service
public class RecordServiceImpl implements RecordService {

	
	@Autowired
	RecordsRepository recordRepository;
	
	
	
	
	@Override
	public Record saveRecord(Record record) {

	
		return recordRepository.save(record);
		
	}

	@Override
	public Record findById(String id) {
		return recordRepository.findByid(id);
	}

	public String deleteRecord(Record record) {
		recordRepository.delete(record);
		return "success";
	}

	public Record updateRecord(Record record) {

		
		return recordRepository.save(record);
		
	}

}
