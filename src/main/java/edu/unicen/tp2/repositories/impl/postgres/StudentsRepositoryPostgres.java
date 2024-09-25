package edu.unicen.tp2.repositories.impl.postgres;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
        Query<Student> query = session
                .createQuery("SELECT s FROM Student s ORDER BY s." + fieldName, Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findAllByGender(String gender) {
        Query<Student> query = session
                .createQuery("SELECT s FROM Student s WHERE s.gender = :gender", Student.class);
        query.setParameter("gender", gender);
        return query.getResultList();
    }

    @Override
    public List<Student> findAllByCareerAndCity(Long careerId, String city) {
        String sql = "SELECT s FROM Student s JOIN s.studentCareers sc WHERE sc.career.id = :careerId AND s.cityOfResidence = :city";
        Query<Student> query = session.createQuery(sql, Student.class);
        query.setParameter("careerId", careerId);
        query.setParameter("city", city);
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
