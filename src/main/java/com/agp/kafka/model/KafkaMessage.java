package com.agp.kafka.model;

public class KafkaMessage {

    private String topicName;
    private String message;

    public KafkaMessage(String topicName,String message){
        this.topicName = topicName;
        this.message = message;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
