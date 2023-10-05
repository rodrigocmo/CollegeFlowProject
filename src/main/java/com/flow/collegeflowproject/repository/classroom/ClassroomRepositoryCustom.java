package com.flow.collegeflowproject.repository.classroom;

import com.flow.collegeflowproject.db.Classroom;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("collegeclassroomrepositorycustom")
public interface ClassroomRepositoryCustom {

    Classroom findVacancies(Long idClass);


}
