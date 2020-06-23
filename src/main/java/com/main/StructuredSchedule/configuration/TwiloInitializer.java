package com.main.StructuredSchedule.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


import com.twilio.Twilio;

@Configuration
public class TwiloInitializer {
	
	
	
	private TwiloConfiguration twiloConfiguration;

	Logger logger = LoggerFactory.getLogger(TwiloInitializer.class);
	
	@Autowired
	public TwiloInitializer(TwiloConfiguration twiloConfiguration) {
		this.twiloConfiguration = twiloConfiguration;
		
		Twilio.init(twiloConfiguration.getAccount_ssid(), twiloConfiguration.getAuth_token());
		logger.info("Twilo INIT " + this.twiloConfiguration.getAccount_ssid());
	}
	
	
	
	
	

}
