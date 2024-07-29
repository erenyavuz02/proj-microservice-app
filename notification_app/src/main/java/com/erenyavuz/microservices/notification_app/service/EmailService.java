package com.erenyavuz.microservices.notification_app.service;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.util.Map;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EmailService {
    
    private final JavaMailSender emailSender;
    private final SpringTemplateEngine templateEngine;


    @Async
    public void sendEmail(String destination, String customerName) {
        try {
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_RELATED, UTF_8.name());
            helper.setFrom("eyavuz21@ku.edu.tr");
            final String templateName = "what is this?";

            Map<String, Object> variables = Map.of("customerName", customerName);
            
            String html = templateEngine.process(templateName, variables);  
            helper.setTo(destination);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
