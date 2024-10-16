package edu.unicen.tp2.repositories.impl.postgres;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import edu.unicen.tp2.dto.CareerInscriptsDTO;
import edu.unicen.tp2.dto.CareerReportDTO;
import edu.unicen.tp2.repositories.BaseJpaRepository;
import edu.unicen.tp2.repositories.CareerRepository;
import edu.unicen.tp2.schema.Career;

public class CareerRepositoryPostgres extends BaseJpaRepository<Career, Long> implements CareerRepository {


    public CareerRepositoryPostgres(Session session) {
        super(session, Career.class);
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

    @Override

    public List<CareerReportDTO> reportCareerWithStudentsInfo() {

        String hql = "SELECT new edu.unicen.tp2.dto.CareerReportDTO(c.name, "
        + "EXTRACT(YEAR FROM COALESCE(  sc.enrolledDate, sc.graduatedDate)), "
        + "COUNT(sc.student), "
        + "COUNT(sc.graduatedDate)) "
        + "FROM StudentCareer sc "
        + "JOIN sc.career c "
        + "WHERE sc.enrolledDate IS NOT NULL OR sc.graduatedDate IS NOT NULL "
        + "GROUP BY c.name, EXTRACT(YEAR FROM COALESCE( sc.enrolledDate, sc.graduatedDate)) "
        + "ORDER BY c.name ASC, EXTRACT(YEAR FROM COALESCE( sc.enrolledDate, sc.graduatedDate)) desc";

        Query<CareerReportDTO> query = session.createQuery(hql, CareerReportDTO.class);

        return query.getResultList();
            
    }
}


