package edu.unicen.tp2.repository;

import edu.unicen.tp2.schema.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentsRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Student> findAllOrderBy(String fieldName) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.id = :id ORDER BY s." + fieldName, Student.class);
        query.setParameter("id", 3L);
        return query.getResultList();
    }

    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
}
