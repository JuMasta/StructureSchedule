package com.main.StructuredSchedule.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import java.net.URISyntaxException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.main.StructuredSchedule.Enums.UserType;
import com.main.StructuredSchedule.configObject.ConfigLinksObject;
import com.main.StructuredSchedule.configObject.ConfigUserObject;
import com.main.StructuredSchedule.dto.UserDTO;
import com.main.StructuredSchedule.models.User;
import com.main.StructuredSchedule.services.CustomUserDetailsService;
import com.main.StructuredSchedule.services.MailSenderService;
import com.main.StructuredSchedule.services.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	ConfigLinksObject configLinks;


	@Autowired
	MailSenderService registrationMailService;

	Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	ConfigUserObject userConfig;
	

	

	
	@PostMapping("/createUserConsumer")
	public ResponseEntity<?> createUserConsumer(@RequestBody UserDTO userDTO) throws Exception {	
		 User user =  userConfig.configObjectForCreate(userDTO,UserType.CONSUMER);	 
		 user =  userServiceImpl.createUser(user);
		 EntityModel<User> entityModel = new EntityModel<User>(user); 
		 entityModel.add(configLinks.getBeginLinks(userDTO));
		 registrationMailService.sendService(user);
		return new ResponseEntity<EntityModel<User>>(entityModel , HttpStatus.OK); 
		
	}

	@PostMapping("/createUserProducer")
	public ResponseEntity<?> createUserProducer(@RequestBody UserDTO userDTO) throws Exception {
		User user = userConfig.configObjectForCreate(userDTO, UserType.PRODUCER);
		user =  userServiceImpl.createUser(user);
		 EntityModel<User> entityModel = new EntityModel<User>(user); 
		 entityModel.add(configLinks.getBeginLinks(userDTO));
		 registrationMailService.sendService(user);
		return new ResponseEntity<EntityModel<User>>(entityModel , HttpStatus.OK); 
		
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO)
	{
		
			
			User user = userConfig.configObjectForUpdate(userDTO);
			userServiceImpl.saveUser(user);	
			return  new ResponseEntity<String>("Успешная смена пользвателя" , HttpStatus.OK);
		
				
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable String id) throws URISyntaxException {
		
	
			User user = userServiceImpl.findById(id);
			UserDTO userDTO = new UserDTO(user);
			EntityModel<UserDTO> entityModel = new EntityModel<>(userDTO,
					linkTo(methodOn(this.getClass()).getUser(id)).withSelfRel(),
					linkTo(methodOn(UserRestController.class).findAll()).withRel("users")
							
							
					
					);
		
			   
			  
			   return new ResponseEntity<EntityModel<UserDTO>>(entityModel, HttpStatus.OK);
		
		
	}
	
	
	@PostMapping("/activate/{code}")
	public ResponseEntity<?> activateUser(@PathVariable String code) throws Exception {
		
		
		boolean isActivated = userServiceImpl.activateUser(code);
		if(isActivated)
		{
			return new ResponseEntity<String>("Пользователь успешно активирован" , HttpStatus.OK);
			
		}
		else {
			
			return new ResponseEntity<String>("Пользователь не найден или не верный код" , HttpStatus.BAD_REQUEST);
			
		}
	
		 
		
	}	
	
	@GetMapping("/getAll")
	public  List<User> findAll()
	{
		
		return userServiceImpl.findAll();
	}
	

	
	

}
