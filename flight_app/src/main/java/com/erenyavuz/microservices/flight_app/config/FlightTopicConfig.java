package com.erenyavuz.microservices.flight_app.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class FlightTopicConfig {


    @Bean
    public NewTopic flightTopic() {
        return TopicBuilder
                .name("flight-topic")
                .build();
    }
    
}
