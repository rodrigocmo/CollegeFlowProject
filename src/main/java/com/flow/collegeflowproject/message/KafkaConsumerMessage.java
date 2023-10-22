package com.flow.collegeflowproject.message;

import com.flow.collegeflowproject.service.ClassroomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {

    @Autowired
    @Qualifier("collegeclassroomservice")
    ClassroomService classService;

    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);

    @KafkaListener(topics = "student-increase-topic", groupId = "college-group")
    public void listeningDecrease(Long idClassroom) {
        classService.changeQtStudentFromClass(idClassroom,Boolean.FALSE);
       //do tomorrow
    }
    @KafkaListener(topics = "student-increase-topic", groupId = "college-group")
    public void listeningIncrease(Long idClassroom) {
        classService.changeQtStudentFromClass(idClassroom,Boolean.TRUE);
        //do tomorrow
    }


}
