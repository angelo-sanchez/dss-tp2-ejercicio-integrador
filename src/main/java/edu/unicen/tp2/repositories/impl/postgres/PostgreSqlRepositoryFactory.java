package edu.unicen.tp2.repositories.impl.postgres;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.unicen.tp2.repositories.CareerRepository;
import edu.unicen.tp2.repositories.RepositoryFactory;
import edu.unicen.tp2.repositories.StudentsRepository;

public class PostgreSqlRepositoryFactory extends RepositoryFactory {

    public Session openConnection(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
        return sessionFactory.openSession();
    }

    @Override
    public StudentsRepository getStudentsRepository() {
        var session = openConnection();
        return new StudentsRepositoryPostgres(session);
    }

    @Override
    public CareerRepository getCareerRepository() {

        var session = openConnection();
        
        return new CareerRepositoryPostgres(session);
    }
    
}
