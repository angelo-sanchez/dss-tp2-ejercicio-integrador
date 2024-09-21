package edu.unicen.tp2.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unicen.tp2.dto.CareerInscriptsDTO;
import edu.unicen.tp2.schema.Career;
import edu.unicen.tp2.schema.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


@Repository
public class CarreerRepository  {

    @PersistenceContext
    EntityManager entityManager;

    public Career findById(long id){
        return entityManager.find(Career.class, id);
    }

    public List<CareerInscriptsDTO> findCareersWithStudentCount() {
        String jpql = "SELECT c, COUNT(sc) as count FROM Career c "
                    + "LEFT JOIN StudentCareer sc ON c.id = sc.career.id "
                    + "GROUP BY c.id "
                    + "ORDER BY COUNT(sc) DESC";
        
        TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
        List<Object[]> results = query.getResultList();

        List<CareerInscriptsDTO> dtos = new ArrayList<>();
        
        for (Object[] result : results) {
            Career career = (Career) result[0];
            long count = (long) result[1];
            dtos.add(new CareerInscriptsDTO(career, count));
        }
        return dtos;
    }
}
