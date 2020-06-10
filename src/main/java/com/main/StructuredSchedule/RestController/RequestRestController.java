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
import com.main.StructuredSchedule.models.Request;
import com.main.StructuredSchedule.models.User;
import com.main.StructuredSchedule.services.RequestServiceImpl;

@RestController
@RequestMapping("/request")
public class RequestRestController {
	
	
	@Autowired
	RequestServiceImpl requestService;
	
//	@PostMapping("/create")
//	public RecordRequest createUserConsumer(@RequestBody RecordRequest req) {	
//		
//		return requestService.createRequest(req);	
//		
//	}
//	
//	@GetMapping("/{id}")
//	public RecordRequest getRequest(@PathVariable String id) {	
//		
//		return requestService.findById(id);	
//		
//	}
//	
//	
//	@PutMapping("/update")
//	public RecordRequest updateRequest(@RequestBody RecordRequest req) {	
//		
//		return requestService.updateRequest(req);	
//		
//	}
//
//	
//	@DeleteMapping("/delete")
//	public String deleteRequest(@RequestBody RecordRequest req) {	
//		
//		return requestService.deleteRequest(req);	
//		
//	}
	
	
}
