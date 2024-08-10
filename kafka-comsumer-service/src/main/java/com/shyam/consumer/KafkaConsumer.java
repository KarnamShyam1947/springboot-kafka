package com.shyam.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.shyam.dto.UserDTO;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "demo-topic", groupId = "demo-group")
    public void consume(UserDTO user) {
        try{
            System.out.println("Consumer consumed : " + user.toString());
        }
        catch(Exception e) {
            System.out.println(e.toString());
        }
    }

}
