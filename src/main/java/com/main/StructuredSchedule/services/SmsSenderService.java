package com.main.StructuredSchedule.services;

import com.main.StructuredSchedule.UsefullObjects.SmsRequest;

public interface SmsSenderService {

	public void sendSms(SmsRequest sms);
	
}
