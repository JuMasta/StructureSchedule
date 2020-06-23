package com.main.StructuredSchedule.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TwiloConfiguration {
	
	
	  private String account_ssid = "ACa3712d5e254e3755b6db468cf91e77e3";
	  private String auth_token = "48cdbbbddaf01e3dcda505f0e460574a";
	  private String trialNumber = "+12563715365";
	public String getTrialNumber() {
		return trialNumber;
	}
	public String getAccount_ssid() {
		return account_ssid;
	}
	public String getAuth_token() {
		return auth_token;
	}

}
