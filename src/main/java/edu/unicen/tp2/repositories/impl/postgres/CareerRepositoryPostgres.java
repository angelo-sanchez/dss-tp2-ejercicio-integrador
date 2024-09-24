package edu.unicen.tp2.repositories.impl.postgres;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import edu.unicen.tp2.dto.CareerInscriptsDTO;
import edu.unicen.tp2.repositories.CareerRepository;
import edu.unicen.tp2.schema.Career;

public class CareerRepositoryPostgres implements CareerRepository {

    Session session;

    public CareerRepositoryPostgres(Session session) {
        this.session = session;
    }

    @Override
    public Career findById(long id) {
        
        return session.find(Career.class, id);
    }

    @Override
    public List<CareerInscriptsDTO> findCareersWithStudentCount() {
        String hql = "SELECT c, COUNT(sc) as count FROM Career c "
            + "LEFT JOIN StudentCareer sc ON c.id = sc.career.id "
            + "GROUP BY c.id "
            + "ORDER BY COUNT(sc) DESC";

        Query<Object[]> query = session.createQuery(hql, Object[].class);
        List<Object[]> results = query.list();

        List<CareerInscriptsDTO> dtos = new ArrayList<>();

        for (Object[] result : results) {
            Career career = (Career) result[0];
            long count = (long) result[1];
            dtos.add(new CareerInscriptsDTO(career, count));
        }
        
        return dtos;
    }
    
}


