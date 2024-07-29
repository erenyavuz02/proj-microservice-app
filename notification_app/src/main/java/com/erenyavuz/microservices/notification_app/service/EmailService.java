package com.erenyavuz.microservices.notification_app.service;

import static java.nio.charset.StandardCharsets.UTF_8;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;

import jakarta.mail.internet.MimeMessage;


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

            Map<String, Object> variables
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
