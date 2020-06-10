package com.main.StructuredSchedule.models;


import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("record")
public class Record {

	@Id
	private String id;
	
	
	private Date dateBegin;
	
	
	private Date dateEnd;
	
	
	@DBRef
	private User userProducer;
	
	
	@DBRef
	private User userConsumer;
	
	
	
	private long dateBeginInMiliSeconds;
	
	
	
	private long dateEndInMiliSeconds;
	
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getDateBegin() {
		return dateBegin;
	}


	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}


	public Date getDateEnd() {
		return dateEnd;
	}


	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}


	public User getUserProducer() {
		return userProducer;
	}


	public void setUserProducer(User userProducer) {
		this.userProducer = userProducer;
	}


	public User getUserConsumer() {
		return userConsumer;
	}


	public void setUserConsumer(User userConsumer) {
		this.userConsumer = userConsumer;
	}


	public long getDateBeginInMiliSeconds() {
		return dateBeginInMiliSeconds;
	}


	public void setDateBeginInMiliSeconds(long dateBeginInMiliSeconds) {
		this.dateBeginInMiliSeconds = dateBeginInMiliSeconds;
	}


	public long getDateEndInMiliSeconds() {
		return dateEndInMiliSeconds;
	}


	public void setDateEndInMiliSeconds(long dateEndInMiliSeconds) {
		this.dateEndInMiliSeconds = dateEndInMiliSeconds;
	}


	public Record() {
		super();
	}


	
	

	
	
	
	
	

	



}
