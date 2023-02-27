package com.UmmahsKitchen.EmailService.API;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UmmahsKitchen.EmailService.Services.EmailService;


@RestController
@RequestMapping("/email-service")	
public class EmailServiceAPI {
	
	@Autowired
	private EmailService emailService;
	
	@PutMapping(value = "/send-email")
	public void sendEmail(@RequestBody final List<String> messages) {
		String recipient = messages.get(0);
        String subject = "Amazon SES SMTP Interface";
        String content = messages.get(1);

        try {
            emailService.sendEmail(recipient, subject, content);
        } catch (UnsupportedEncodingException | MessagingException e) {
            System.out.println(e.getStackTrace());
        }
	}
}
