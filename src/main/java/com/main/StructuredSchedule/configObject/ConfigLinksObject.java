package com.main.StructuredSchedule.configObject;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import com.main.StructuredSchedule.RestController.AuthenticateRestController;
import com.main.StructuredSchedule.RestController.RecordRestController;
import com.main.StructuredSchedule.RestController.RequestRestController;
import com.main.StructuredSchedule.RestController.UserRestController;
import com.main.StructuredSchedule.models.Record;
import com.main.StructuredSchedule.models.User;

@Service
public class ConfigLinksObject {
	
	 Logger logger = LoggerFactory.getLogger(ConfigLinksObject.class);
	
	public List<Link> getUserProducerLinks(User user)  throws URISyntaxException{
		List<Link> list = new ArrayList<Link>();
//		list.add(linkTo(methodOn(UserRestController.class).getUser(user.getId())).withRel("Получение текущего пользователя"));
//		list.add(linkTo(methodOn(UserRestController.class).getUser("id")).withRel("Получение пользователя"));
//		list.add(linkTo(methodOn(UserRestController.class).findAll()).withRel("Все пользователи"));
////		list.add(linkTo(methodOn(RecordRestController.class).createRecord(new Record())).withRel("Создание записи"));
//		list.add(linkTo(methodOn(RecordRestController.class).getRecord("id")).withRel("Получение записи"));
//		list.add(linkTo(methodOn(RequestRestController.class).getRequest("id")).withRel("Получение заявки"));
//		list.add(linkTo(methodOn(RequestRestController.class).createUserConsumer(new RecordRequest())).withRel("Создание заявки"));
////		list.add(linkTo(methodOn(RecordRestController.class).updateRecord(new Record())).withRel("Редактрование записи"));
////		list.add(linkTo(methodOn(RecordRestController.class).deleteRecord(new Record())).withRel("Удаление записи"));
//		list.add(linkTo(methodOn(RequestRestController.class).updateRequest(new RecordRequest())).withRel("Изменение заявки"));
//		list.add(linkTo(methodOn(RequestRestController.class).deleteRequest(new RecordRequest())).withRel("Удаление заявки"));
		return list;
		
		
	}
	
	public List<Link> getUserСonsumerLinks(User user)  throws URISyntaxException{
		List<Link> list = new ArrayList<Link>();
//		list.add(linkTo(methodOn(UserRestController.class).getUser(user.getId())).withRel("Получение текущего пользователя"));
//		list.add(linkTo(methodOn(UserRestController.class).getUser("id")).withRel("Получение пользователя"));
//		list.add(linkTo(methodOn(UserRestController.class).findAll()).withRel("Все пользователи"));
//		list.add(linkTo(methodOn(RecordRestController.class).getRecord("id")).withRel("Получение записи"));
//		list.add(linkTo(methodOn(RequestRestController.class).getRequest("id")).withRel("Получение заявки"));
//		list.add(linkTo(methodOn(RequestRestController.class).createUserConsumer(new RecordRequest())).withRel("Создание заявки"));
//		list.add(linkTo(methodOn(RequestRestController.class).updateRequest(new RecordRequest())).withRel("Изменение заявки"));
//		list.add(linkTo(methodOn(RequestRestController.class).deleteRequest(new RecordRequest())).withRel("Удаление заявки"));
		return list;
		
		
	}
	
	public List<Link> getBeginLinks(User user) throws Exception {
		
		List<Link> list = new ArrayList<Link>();
		list.add(linkTo(methodOn(AuthenticateRestController.class).generateToken(user)).withRel("Аутентификация и авторизация"));		
		return list;
		
	}

}
