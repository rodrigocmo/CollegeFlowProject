package com.flow.collegeflowproject.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);


    /*
    @KafkaListener(topics = "student-info-topic", groupId = "college-group")
     */
    public void listening(String test) {

        LOG.info("CAR STORE - Received Car Post information: {}", test);

       //do tomorrow
    }


}
