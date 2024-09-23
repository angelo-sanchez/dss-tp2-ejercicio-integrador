package edu.unicen.tp2.repositories;

import java.util.List;

import org.hibernate.Session;

import edu.unicen.tp2.schema.Career;

public class CareerRepositoryPostgre implements CareerRepository {

    Session session;

    public CareerRepositoryPostgre(Session session) {
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


