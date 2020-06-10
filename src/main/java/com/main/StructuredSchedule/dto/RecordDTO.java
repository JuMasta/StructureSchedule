package com.main.StructuredSchedule.dto;

public class RecordDTO {
	

	
	private String idUserConsumer;
	
	private long dateBeginInMiliSeconds;
	
	private long dateEndInMiliSeconds;

	public long getDateEndInMiliSeconds() {
		return dateEndInMiliSeconds;
	}

	public void setDateEndInMiliSeconds(long dateEndInMiliSeconds) {
		this.dateEndInMiliSeconds = dateEndInMiliSeconds;
	}

	

	public String getIdUserConsumer() {
		return idUserConsumer;
	}

	public void setIdUserConsumer(String idUserConsumer) {
		this.idUserConsumer = idUserConsumer;
	}

	public long getDateBeginInMiliSeconds() {
		return dateBeginInMiliSeconds;
	}

	public void setDateBeginInMiliSeconds(long dateBeginInMiliSeconds) {
		this.dateBeginInMiliSeconds = dateBeginInMiliSeconds;
	}
	

}
