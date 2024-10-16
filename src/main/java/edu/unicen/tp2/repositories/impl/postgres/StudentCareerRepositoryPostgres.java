package edu.unicen.tp2.repositories.impl.postgres;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.unicen.tp2.repositories.BaseJpaRepository;
import edu.unicen.tp2.repositories.StudentCareerRepository;
import edu.unicen.tp2.schema.Career;
import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.schema.StudentCareer;
import edu.unicen.tp2.schema.StudentCareerId;

public class StudentCareerRepositoryPostgres extends BaseJpaRepository<StudentCareer, StudentCareerId> implements StudentCareerRepository {


    public StudentCareerRepositoryPostgres(Session session) {
        super(session, StudentCareer.class);
    }

    @Override
    public StudentCareer save(Student student, Career career) {

        Transaction tx = session.beginTransaction();

        student = session.merge(student);

        career = session.merge(career);

        var studentCareer = new StudentCareer();
        
        var studentCarerId = new StudentCareerId(student.getId(), career.getId());
        
        studentCareer.setId(studentCarerId);
        studentCareer.setCareer(career);
        studentCareer.setStudent(student);

        session.persist(studentCareer);

        tx.commit();

        return studentCareer;
        

    }

    
}
