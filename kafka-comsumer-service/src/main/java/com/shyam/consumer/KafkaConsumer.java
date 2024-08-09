package com.shyam.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "demo-topic", groupId = "demo-group")
    public void consume(String message) {
        System.out.println("Consumer consumed : " + message);
    }

}
