package edu.unicen.tp2.repositories.impl.postgres;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.unicen.tp2.repositories.CareerRepository;
import edu.unicen.tp2.repositories.RepositoryFactory;
import edu.unicen.tp2.repositories.StudentCareerRepository;
import edu.unicen.tp2.repositories.StudentsRepository;

public class PostgreSqlRepositoryFactory extends RepositoryFactory {

    private Session session;

    public Session openConnection(){

        if(session != null) return session;

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
        session = sessionFactory.openSession();

        return session;
    }

    public void closeConnection(){
        session.close();
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

    @Override
    public StudentCareerRepository getStudentCareerRepository() {
        
        var session = openConnection();

        return new StudentCareerRepositoryPostgres(session);
    }
    
}
