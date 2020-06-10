package com.main.StructuredSchedule.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.main.StructuredSchedule.configObject.ConfigRecordObject;
import com.main.StructuredSchedule.configObject.ConfigUserObject;
import com.main.StructuredSchedule.dto.RecordDTO;
import com.main.StructuredSchedule.models.Record;
import com.main.StructuredSchedule.models.User;
import com.main.StructuredSchedule.services.RecordServiceImpl;
import com.main.StructuredSchedule.services.UserServiceImpl;


@RestController
@RequestMapping("/record")
public class RecordRestController {

	
	@Autowired
	RecordServiceImpl recordService;
	
	@Autowired
	UserServiceImpl userService;
	

	
	@Autowired
	ConfigRecordObject recordConfig;
	
	@Autowired
	ConfigUserObject userConfig;	

	@PostMapping("/create")
	public  Record createRecord(@RequestBody RecordDTO recordDTO)
	{
		Record record = recordConfig.configObjectForSave(recordDTO);
		recordService.saveRecord(record);
		User userProducer = userConfig.configObjectByRecord(record.getUserProducer(), record);
		userService.saveUser(userProducer);
		userProducer.setRecords(null);
		if(record.getUserConsumer() != null)
		{
			User userConsumer = userConfig.configObjectByRecord(record.getUserConsumer(), record);
			userService.saveUser(userConsumer);
			userConsumer.setRecords(null);
		}
		return record;
		
		
	}
	@GetMapping("/{id}")
	public  Record getRecord(@PathVariable String id)
	{
		
		return recordService.findById(id);
	}
	
	
	@PutMapping("/update/{id}")
	public Record updateRecord(@RequestBody Record record,@PathVariable String id) {	
		
		return recordService.updateRecord(recordService.findById(id));	
		
	}

	
	@DeleteMapping("/delete/{id}")
	public String deleteRecord(@RequestBody Record record,@PathVariable String id) {	
		
		return recordService.deleteRecord(record);	
		
	}
	

	
}
