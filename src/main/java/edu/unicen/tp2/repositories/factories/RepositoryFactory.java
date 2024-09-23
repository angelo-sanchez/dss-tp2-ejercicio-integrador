package edu.unicen.tp2.repositories.factories;

import edu.unicen.tp2.repositories.CareerRepository;
import edu.unicen.tp2.repositories.StudentsRepository;

public abstract class RepositoryFactory {
    
    public static final int POSTGRESQL_HIB = 1;

    private static RepositoryFactory postgreSqlRepositoryFactory;

    public abstract StudentsRepository getStudentsRepository();

    public abstract CareerRepository getCareerRepository();

    public static RepositoryFactory getRepositoryFactory(int witchFactory){

        // Switch - Case. devolviendo instancia correspondiente al parametro.

        if(witchFactory == RepositoryFactory.POSTGRESQL_HIB){
            
            // Esto lo hago para que sea singleton.

            if(postgreSqlRepositoryFactory == null) postgreSqlRepositoryFactory = new PostgreSqlRepositoryFactory();

            return postgreSqlRepositoryFactory; 

        }
        
        return null;
    }
}
