package com.flow.collegeflowproject.repository.shift;


import com.collegeclassroom.db.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRepository extends JpaRepository<Shift,Long> {
}
