package edu.unicen.tp2.repositories.impl.postgres;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import edu.unicen.tp2.repositories.StudentsRepository;
import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.schema.StudentCareer;
import jakarta.persistence.TypedQuery;

public class StudentsRepositoryPostgres implements StudentsRepository {
    private final Session session;

    public StudentsRepositoryPostgres(Session session) {
        this.session = session;
    }

    @Override
    public List<Student> findAllOrderBy(String fieldName) {
        TypedQuery<Student> query = session.createQuery(
                "SELECT s FROM Student s ORDER BY s." + fieldName, Student.class);
        return query.getResultList();
    }

    @Override
    public Student findById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Student findOneByUniversityBookNumber(String universityBookNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'findOneByUniversityBookNumber'");
    }

    @Override
    public Student save(Student student) {
        Transaction tx = session.beginTransaction();
        session.persist(student);
        tx.commit();
        return student;
    }

    @Override
    public StudentCareer saveStudentCareer(StudentCareer studentCareer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveStudentCareer'");
    }

}
