package com.flow.collegeflowproject.repository.classroom;

import com.flow.collegeflowproject.db.Classroom;
import com.flow.collegeflowproject.db.StatusRecord;
import com.flow.collegeflowproject.exception.GenericExeption;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;


public class ClassroomRepositoryImpl implements ClassroomRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Classroom findVacancies(Long idClass) {
        StringBuilder hql = new StringBuilder("Select new Classroom ( class.vacancies, class.qtStudent )");
        hql.append(" from Classroom class ");
        hql.append(" where class.id = :IDCLASS ");
        hql.append(" and class.status =: STATUS");
        TypedQuery<Classroom> query = entityManager.createQuery(hql.toString(), Classroom.class);
        query.setParameter("IDCLASS", idClass);
        query.setParameter("STATUS", StatusRecord.ACTIVE);
        return query.getResultStream().findFirst().orElseThrow(()-> new GenericExeption("Classroom not found"));
    }
}
