package com.main.StructuredSchedule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.StructuredSchedule.UsefullObjects.SmsRequest;
import com.main.StructuredSchedule.configuration.TwiloConfiguration;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class ActivatationSmsSender implements SmsSenderService {

	
	@Autowired
	TwiloConfiguration twiloConfig;
	
	
	@Override
	public void sendSms(SmsRequest sms) {
		  MessageCreator message = Message.creator(new PhoneNumber(sms.getPhoneNumber()),
				  new PhoneNumber(twiloConfig.getTrialNumber()),
				  sms.getMessage());
		  message.create();

	}

}
