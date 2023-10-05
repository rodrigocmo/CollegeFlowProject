package com.flow.collegeflowproject.repository.classroom;

import com.flow.collegeflowproject.db.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
@Component("collegeclassroomrepository")
public interface ClassroomRepository extends JpaRepository<Classroom,Long>, ClassroomRepositoryCustom {
}
