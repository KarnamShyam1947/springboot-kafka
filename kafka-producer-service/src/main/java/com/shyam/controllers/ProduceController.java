package com.shyam.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shyam.dto.UserDTO;
import com.shyam.services.ProducerService;

@RestController
public class ProduceController {

    private final ProducerService producerService;

    public ProduceController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/produce/{message}")
    public String produce(
        @PathVariable("message") String message,
        @RequestParam(name = "number", defaultValue = "100") String number
    ) {

        int times = Integer.parseInt(number);
        for (int i = 0; i < times; i++)     
            producerService.produce(message + i);
        
        return "Message published successfully";
    }
    
    @PostMapping("/produce/")
    public String produce(
        @RequestBody UserDTO user
    ) {
        
        producerService.produce(user);
        
        return "Message published successfully";
    }
    
}
