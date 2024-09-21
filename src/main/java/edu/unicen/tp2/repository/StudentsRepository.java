package edu.unicen.tp2.repository;

import edu.unicen.tp2.schema.Career;
import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.schema.StudentCareer;
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

    public Student findById(long id){
        return entityManager.find(Student.class, id);
    }

    public Student findOneByUniversityBookNumber(String universityBookNumber){


    try {
        return entityManager.createQuery(
            "SELECT s FROM Student s WHERE s.universityBookNumber = :universityBookNumber", Student.class)
            .setParameter("universityBookNumber", universityBookNumber)
            .getSingleResult();
    } catch (Exception e) {
        return null;
    }

    }



    @Transactional
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Transactional
    public StudentCareer saveStudentCareer(StudentCareer studentCareer){ // Lo pongo aca, o en un StudentCarreerRepository?
        
        entityManager.persist(studentCareer);

        return studentCareer;
    }
}
