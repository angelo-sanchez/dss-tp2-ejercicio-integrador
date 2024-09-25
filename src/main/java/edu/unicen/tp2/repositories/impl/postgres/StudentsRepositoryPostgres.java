package edu.unicen.tp2.repositories.impl.postgres;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import edu.unicen.tp2.repositories.StudentsRepository;
import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.schema.StudentCareer;

public class StudentsRepositoryPostgres implements StudentsRepository {
    private final Session session;

    public StudentsRepositoryPostgres(Session session) {
        this.session = session;
    }

    @Override
    public List<Student> findAllOrderBy(String fieldName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllOrderBy'");
    }

    @Override
    public Student findById(long id) {
        return session.find(Student.class, id);
    }

    @Override
    public Student findOneByUniversityBookNumber(String universityBookNumber) {
            try {
                return session.createQuery(
                    "SELECT s FROM Student s WHERE s.universityBookNumber = :universityBookNumber", Student.class)
                    .setParameter("universityBookNumber", universityBookNumber)
                    .uniqueResult();
            } catch (Exception e) {
                return null; // En caso de que haya una excepción, retornamos null
            } 
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

        Transaction tx = session.beginTransaction();

        session.persist(studentCareer);

        tx.commit();

        return studentCareer;
    }

}
