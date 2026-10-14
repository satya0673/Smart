package com.shms.mail.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {
	
	private final JavaMailSender sender;
	
	public void sendOtp(String email,String otp) {
		SimpleMailMessage msg= new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("OTP Verification");
		msg.setText("Your OTP is :"+otp);
		
		sender.send(msg);
	}

}
