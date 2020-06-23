package com.main.StructuredSchedule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.main.StructuredSchedule.models.User;


@Service
public class RegistrationEmailService implements MailSenderService {

	@Autowired
    private JavaMailSender javaMailSender;
	
	private String message = "Для активации вашего аккаунта, используйте код %s";
	
	@Override
	public void sendService(User user) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(user.getPhoneNumber());       
        msg.setSubject("Активация аккаунта");       
        msg.setText(String.format(message, user.getActivationCode()));    
        javaMailSender.send(msg);

	}

}
