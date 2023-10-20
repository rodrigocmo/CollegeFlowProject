package com.flow.collegeflowproject.service;

import com.flow.collegeflowproject.db.Classroom;
import com.flow.collegeflowproject.db.StatusRecord;
import com.flow.collegeflowproject.db.dtoandrecords.ClassroomRecord;
import com.flow.collegeflowproject.exception.GenericExeption;
import com.flow.collegeflowproject.external.RestTemplateConfigs;
import com.flow.collegeflowproject.external.RestTemplateRequests;
import com.flow.collegeflowproject.repository.classroom.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
@Component("collegeclassroomservice")
public class ClassroomService {

    @Autowired
    @Qualifier("collegeclassroomrepository")
    ClassroomRepository repository;

    @Autowired
    RestTemplateRequests restTemplateRequests;



    public List<Classroom> findAllClass(){
        return repository.findAll();
    }

    public Classroom findClassById(Long id) {
        return repository.findById(id).orElseThrow(()-> new GenericExeption("Classroom not found"));
    }

    public ClassroomRecord create(Classroom classroom){
        classroom.setStatus(StatusRecord.ACTIVE);
      repository.save(classroom);
        return restTemplateRequests.sendClassroomToStudentService(classroom);
    }

    public Long findVacancies(Long idClass){
        Classroom classroom = repository.findVacancies(idClass);
        return classroom.getVacancies() - classroom.getQtStudent();
    }
}
