package com.flow.collegeflowproject.repository.period;


import com.collegeclassroom.db.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends JpaRepository<Period,Long> {
}
