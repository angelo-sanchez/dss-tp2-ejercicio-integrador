package edu.unicen.tp2.repositories.impl.postgres;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.unicen.tp2.repositories.StudentCareerRepository;
import edu.unicen.tp2.schema.Career;
import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.schema.StudentCareer;
import edu.unicen.tp2.schema.StudentCareerId;
import java.util.List;

public class StudentCareerRepositoryPostgres implements StudentCareerRepository {

    private Session session;

    public StudentCareerRepositoryPostgres(Session session) {
        this.session = session;
    }

    @Override
    public StudentCareer save(Student student, Career career) {

        Transaction tx = session.beginTransaction();

        student = session.merge(student);

        career = session.merge(career);

        var studentCareer = new StudentCareer();
        
        var studentCarerId = new StudentCareerId();

        studentCarerId.setCareerId(career.getId());
        studentCarerId.setStudentId(student.getId());
        
        studentCareer.setId(studentCarerId);
        studentCareer.setCareer(career);
        studentCareer.setStudent(student);

        session.persist(studentCareer);

        tx.commit();

        return studentCareer;
        

    }

    @Override
    public StudentCareer save(StudentCareer entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public StudentCareer findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void delete(StudentCareer entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<StudentCareer> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
