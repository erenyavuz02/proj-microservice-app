package com.erenyavuz.microservices.notification_app.service;

import static java.nio.charset.StandardCharsets.UTF_8;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.erenyavuz.microservices.notification_app.dto.ReservationConfirmation;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EmailService {
    
    private final JavaMailSender emailSender;
    private final SpringTemplateEngine templateEngine;


    @Async
    public void sendEmail(ReservationConfirmation reservation) {
        try {
            MimeMessage mimeMessage = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_RELATED, UTF_8.name());
            helper.setFrom("eyavuz21@ku.edu.tr");
            final String templateName = "reservationConfirmation";
            Context context = new Context();
            context.setVariable("customerName", reservation.name());
            context.setVariable("customerSurname", reservation.surname());
            context.setVariable("flightNumber", reservation.flightNumber());
            context.setVariable("departurePort", reservation.departurePort());
            context.setVariable("arrivalPort", reservation.arrivalPort());
            context.setVariable("flightDate", reservation.flightDate());
            context.setVariable("pnr", reservation.PNR());

            String html = templateEngine.process(templateName, context);
            helper.setTo(reservation.email());
            helper.setText(html, true);
            emailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
