package com.erenyavuz.microservices.notification_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class NotificationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationAppApplication.class, args);
	}

}
