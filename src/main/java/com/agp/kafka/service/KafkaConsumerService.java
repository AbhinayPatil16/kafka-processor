package com.agp.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "sample-topic",groupId =  "")
    public void consume(String message){

        //convert your message into any working pojo you want
        logger.info("Received message - {}",message);

    }

}
