package com.flow.collegeflowproject.controller;

import com.collegeclassroom.db.Classroom;
import com.collegeclassroom.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/classroom")
@RestController
@Component("collegeclassroomcontroller")
public class ClassroomCtr {

        @Autowired
        @Qualifier("collegeclassroomservice")
        ClassroomService service;

    @GetMapping
    public ResponseEntity<List<Classroom>> findAllClass() {
        return new ResponseEntity<>(service.findAllClass(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Classroom> findCLassById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findClassById(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Classroom> create(@RequestBody Classroom classroom){
        return new ResponseEntity<>(service.create(classroom),HttpStatus.CREATED);
    }

    @GetMapping(path = "/vacancies/{idClass}")
    public ResponseEntity<Long> findVacancies(@PathVariable Long idClass) {
        return new ResponseEntity<>(service.findVacancies(idClass),HttpStatus.OK);
    }

}
