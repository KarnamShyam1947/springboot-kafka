package com.shyam.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.shyam.dto.UserDTO;

@Service
public class ProducerService {

    @Value("${application.kafka.topic-name}")
    private String topicName;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(String message) {
        CompletableFuture<SendResult<String, Object>> send = kafkaTemplate.send(topicName, message);

        send.whenComplete((result, e) -> {
            if (e == null) 
                System.out.println("Send Message : [" + message + "]");

            else
                System.out.println("Error : " + e.getMessage());
            
        });
    }
    
    public void produce(UserDTO user) {
        CompletableFuture<SendResult<String, Object>> send = kafkaTemplate.send(topicName, user);

        send.whenComplete((result, e) -> {
            if (e == null) 
                System.out.println("Send Message : [" + user + "]");

            else
                System.out.println("Error : " + e.getMessage());
            
        });
    }
    
}
