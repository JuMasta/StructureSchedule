package com.main.StructuredSchedule.configObject;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.main.StructuredSchedule.dto.RecordDTO;
import com.main.StructuredSchedule.models.Record;
import com.main.StructuredSchedule.models.User;
import com.main.StructuredSchedule.services.CustomUserDetailsService;
import com.main.StructuredSchedule.services.RecordServiceImpl;
import com.main.StructuredSchedule.services.UserServiceImpl;


@Service
public class ConfigRecordObject {

	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	RecordServiceImpl recordService;
	
	
	Logger logger = LoggerFactory.getLogger(ConfigRecordObject.class);
	
	public Record configObjectForSave(RecordDTO recordDTO) {
		Record record = new Record();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();		
		record.setUserProducer(userService.findByEmail(currentPrincipalName));
		record.setUserConsumer(userService.findById(recordDTO.getIdUserConsumer()));
		record.setDateBegin(new Date(recordDTO.getDateBeginInMiliSeconds()));
		record.setDateEnd(new Date(recordDTO.getDateEndInMiliSeconds()));
		record.setDateBeginInMiliSeconds(recordDTO.getDateBeginInMiliSeconds());
		record.setDateEndInMiliSeconds(recordDTO.getDateEndInMiliSeconds());
//		recordService.saveRecord(record);
//		User user = userService.findByEmail(currentPrincipalName);		
//		List<Record> records =  user.getRecord();
//		records.add(record);
//		userService.saveUser(user);
//		
//		if (record.getUserConsumer() != null)
//		{
//			user = userService.findByEmail(record.getUserConsumer());
//			if (user != null)
//			{
//				user.getRecord().add(record);
//				userService.saveUser(user);
//			}
//		}
		
		return record;
	}

}
