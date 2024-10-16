package edu.unicen.tp2.repositories.impl.postgres;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import edu.unicen.tp2.repositories.BaseJpaRepository;
import edu.unicen.tp2.repositories.StudentsRepository;
import edu.unicen.tp2.schema.Student;

public class StudentsRepositoryPostgres extends BaseJpaRepository<Student, Long> implements StudentsRepository {

    public StudentsRepositoryPostgres(Session session) {
        super(session, Student.class);
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

}
