package edu.unicen.tp2.repositories.factories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.unicen.tp2.repositories.CareerRepository;
import edu.unicen.tp2.repositories.CareerRepositoryPostgre;
import edu.unicen.tp2.repositories.StudentsRepository;

public class PostgreSqlRepositoryFactory extends RepositoryFactory {

    public Session openConnection(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
        return sessionFactory.openSession();
    }

    @Override
    public StudentsRepository getStudentsRepository() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getStudentsRepository'");
    }

    @Override
    public CareerRepository getCareerRepository() {

        var session = openConnection();
        
        return new CareerRepositoryPostgre(session);
    }
    
}
