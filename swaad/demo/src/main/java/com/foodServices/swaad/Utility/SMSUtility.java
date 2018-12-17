package com.foodServices.swaad.Utility;

import java.security.NoSuchAlgorithmException;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class SMSUtility {
	
	private SMSUtility() {}
	
	public static void sendOTP(String msisdn,String strMessage) throws NoSuchAlgorithmException {
		Twilio.init("ACf82d8b7c570c83b1fb4d30b2421028d5", "bcbd751010cd708c4b6a89f90ed84ad3");
		Message message = Message.creator(
	                new com.twilio.type.PhoneNumber("+91"+msisdn),
	                new com.twilio.type.PhoneNumber("5744062049"),
	                strMessage)
	            .create();
		 
		 
	}

}
