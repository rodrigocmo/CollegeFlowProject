package com.flow.collegeflowproject.service;

import com.collegeclassroom.db.Classroom;
import com.collegeclassroom.db.StatusRecord;
import com.collegeclassroom.exception.GenericExeption;
import com.collegeclassroom.repository.classroom.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Component("collegeclassroomservice")
public class ClassroomService {

    @Autowired
    @Qualifier("collegeclassroomrepository")
    ClassroomRepository repository;



    public List<Classroom> findAllClass(){
        return repository.findAll();
    }

    public Classroom findClassById(Long id) {
        return repository.findById(id).orElseThrow(()-> new GenericExeption("Classroom not found"));
    }

    public Classroom create(Classroom classroom){
        classroom.setStatus(StatusRecord.ACTIVE);
     return repository.save(classroom);
    }

    public Long findVacancies(Long idClass){
        Classroom classroom = repository.findVacancies(idClass);
        return classroom.getVacancies() - classroom.getQtStudent();
    }
}
