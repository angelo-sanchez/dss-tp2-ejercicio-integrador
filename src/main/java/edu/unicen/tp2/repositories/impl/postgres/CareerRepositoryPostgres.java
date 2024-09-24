package edu.unicen.tp2.repositories.impl.postgres;

import java.util.List;

import org.hibernate.Session;
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
    public List<Object> findCareersWithStudentCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findCareersWithStudentCount'");
    }
    
}


