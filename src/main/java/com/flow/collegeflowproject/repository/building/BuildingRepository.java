package com.flow.collegeflowproject.repository.building;


import com.flow.collegeflowproject.db.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building,Long> {
}
