package edu.unicen.tp2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.unicen.tp2.repositories.CareerRepository;
import edu.unicen.tp2.repositories.RepositoryFactory;
import edu.unicen.tp2.repositories.StudentsRepository;
import edu.unicen.tp2.schema.Career;
import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.services.StudentService;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        try {
            
            RepositoryFactory repositoryFactory = RepositoryFactory.getRepositoryFactory(RepositoryFactory.POSTGRESQL_HIB);

            /* Inicializamos los repositories */
            CareerRepository careerRepository = repositoryFactory.getCareerRepository();
            StudentsRepository studentsRepository = repositoryFactory.getStudentsRepository();

            /* Inicializamos los services */
            StudentService studentServices = new StudentService(studentsRepository);

            // b.1) dar de alta un estudiante
            Student student = studentServices.createStudent("Juan", "Perez", 20, "987987987", "2494", "M", "Rosario");
            log.info("Se creó el estudiante con id: {}", student.getId());


            Career career = careerRepository.findById(1);
            
            System.out.println(career.getName());
        
        } catch (Exception e) {
            log.error("Ocurrió un error en la ejecución del programa", e);
        }
    }
}