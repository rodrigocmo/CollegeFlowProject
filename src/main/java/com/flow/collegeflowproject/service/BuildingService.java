package com.flow.collegeflowproject.service;

import com.flow.collegeflowproject.db.Building;
import com.flow.collegeflowproject.exception.GenericExeption;
import com.flow.collegeflowproject.repository.building.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    @Autowired
    BuildingRepository repository;


    public List<Building> findAllBuilding(){
        return repository.findAll();
    }

    public Building findBuildingById(Long id) {
        return repository.findById(id).orElseThrow(()-> new GenericExeption("Building not found"));
    }

    public Building create(Building building){
        return repository.save(building);
    }




}
