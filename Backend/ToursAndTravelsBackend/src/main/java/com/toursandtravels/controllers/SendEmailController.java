package com.toursandtravels.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@CrossOrigin(origins = "http://localhost:3000")
public class SendEmailController {
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private com.toursandtravels.Services.EmailService emailService;
	
	@PostConstruct
	public void init()
	{
		System.out.println("in init "+sender);
	}
	
	@PostMapping("/forgot_password/{userName}")
	public ResponseEntity<?> sendForgotPasswordMailOTP(@PathVariable String userName) {
		SimpleMailMessage mesg = emailService.sendPasswordChangeOTPMail(userName);
		sender.send(mesg);
		return ResponseEntity.ok("Sent OTP");
	}
}
