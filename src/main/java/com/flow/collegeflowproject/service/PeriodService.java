package com.flow.collegeflowproject.service;

import com.flow.collegeflowproject.db.Period;
import com.flow.collegeflowproject.exception.GenericExeption;
import com.flow.collegeflowproject.repository.period.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodService {

    @Autowired
    PeriodRepository repository;


    public List<Period> findAllPeriod(){
        return repository.findAll();
    }

    public Period findPeriodById(Long id) {
        return repository.findById(id).orElseThrow(()-> new GenericExeption("Period not found"));
    }

    public Period create(Period period){
        return repository.save(period);
    }




}
