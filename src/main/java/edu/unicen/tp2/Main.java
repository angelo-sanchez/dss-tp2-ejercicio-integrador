package edu.unicen.tp2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.unicen.tp2.repositories.CareerRepository;
import edu.unicen.tp2.repositories.RepositoryFactory;
import edu.unicen.tp2.schema.Career;

public class Main {
    public static void main(String[] args) {

        try {
            
            RepositoryFactory repositoryFactory = RepositoryFactory.getRepositoryFactory(RepositoryFactory.POSTGRESQL_HIB);

            CareerRepository careerRepository = repositoryFactory.getCareerRepository();

            Career career = careerRepository.findById(1);
            
            System.out.println(career.getName());
        
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}