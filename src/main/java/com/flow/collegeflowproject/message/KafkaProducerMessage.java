package com.flow.collegeflowproject.message;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String KAFKA_TOPIC = "student-info-topic";

    public void sendMessage(String test){
        kafkaTemplate.send(KAFKA_TOPIC, test);
    }

}
