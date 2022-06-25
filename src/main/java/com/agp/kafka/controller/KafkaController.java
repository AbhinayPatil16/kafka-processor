package com.agp.kafka.controller;


import com.agp.kafka.model.KafkaMessage;
import com.agp.kafka.service.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final KafkaProducerService producerService;

    public KafkaController(KafkaProducerService producerService){
        this.producerService = producerService;
    }

    @PostMapping("/publish")
    public String publishMessageToTopic(@RequestBody KafkaMessage kafkaMessage){

        producerService.sendKafkaMessage(kafkaMessage.getTopicName(), kafkaMessage.getMessage());
        return "Sent successfully";
    }
}
