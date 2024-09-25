package edu.unicen.tp2;

import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.unicen.tp2.repositories.CareerRepository;
import edu.unicen.tp2.repositories.RepositoryFactory;
import edu.unicen.tp2.repositories.StudentCareerRepository;
import edu.unicen.tp2.repositories.StudentsRepository;
import edu.unicen.tp2.schema.Career;
import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.services.CareerService;
import edu.unicen.tp2.services.StudentCareerService;
import edu.unicen.tp2.services.StudentService;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        try {
            
            RepositoryFactory repositoryFactory = RepositoryFactory.getRepositoryFactory(RepositoryFactory.POSTGRESQL_HIB);

            /* Inicializamos los repositories */
            CareerRepository careerRepository = repositoryFactory.getCareerRepository();
            StudentsRepository studentsRepository = repositoryFactory.getStudentsRepository();
            StudentCareerRepository studentCareerRepository = repositoryFactory.getStudentCareerRepository();
            

            /* Inicializamos los services */
            CareerService careerService = new CareerService(careerRepository);
            StudentService studentServices = new StudentService(studentsRepository);
            StudentCareerService studentCareerService = new StudentCareerService(studentsRepository, careerRepository, studentCareerRepository);

            Career career = careerRepository.findById(1);
            
            System.out.println(career.getName());


            /* Ejecutamos los métodos */
            darDeAltaEstudiante(studentServices);
            matricularEstudianteCarrera(studentCareerService, 1, 1); // La carrera debe estar previamente creada.
            recuperarEstudiantesOrdenado(studentServices, "lastName");
            recuperarEstudiantePorLibretaUniversitaria(studentServices, "2494");
            recuperarEstudiantesPorGenero(studentServices, "Male");
            carrerasInscriptosOrdenada(careerService);
            recuperarEstudiantesPorCarreraYCiudad(studentServices, 1, "Olavarria");


            repositoryFactory.closeConnection();

        } catch (Exception e) {
            log.error("Ocurrió un error en la ejecución del programa", e);
        }
    }

    /**
     * b.1) dar de alta un estudiante.
     */
    public static void darDeAltaEstudiante(StudentService sv) {
        Student s = sv.createStudent(
            "Juan",
            "Perez",
            20,
            "987987987",
            "2494",
            "Male",
            "Rosario"
        );
        var data = String.format("%s %s - (%s)", s.getFirstName(), s.getLastName(), s.getDocumentNumber());
        log.info("Se creó el estudiante {} con id: {}",data, s.getId());
    }

    /**
     * b.2) matricular un estudiante en una carrera.
    */

    public static void matricularEstudianteCarrera(StudentCareerService studentCareerService, long studentid, long careerId){
        
        var studentCareer = studentCareerService.addStudentToCareer(studentid, careerId);

        if(studentCareer == null){
            log.info("No se pudo matricular el estudiante {} a la carrera {}", studentid, careerId);
            return;
        }

        log.info("Se pudo matricular correctamente al estudiante");

    }

    /**
     * b.3) recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
     */
    public static void recuperarEstudiantesOrdenado(StudentService sv, String orderBy) {
        var students = sv
                .getStudents(orderBy).stream().map(s -> String.format("%s %s - (%s)",
                        s.getFirstName(), s.getLastName(), s.getDocumentNumber()))
                .collect(Collectors.joining(" *** "));
        log.info("Estudiantes ordenados por {}: {}", orderBy, students);
    }

    /**
     * b.4)     recuperar un estudiante, en base a su número de libreta universitaria.
    */
    public static void recuperarEstudiantePorLibretaUniversitaria(StudentService sv, String libretaUniversitaria){

        var student = sv.findOneByUniversityBookNumber(libretaUniversitaria);

        if(student == null){
            log.info("Estudiante no encontrado");
            return;
        }

        log.info("Estudiante encontrado: {}", student.getId());

    }



    /**
     * b.5) recuperar todos los estudiantes, en base a su género.
     */
    public static void recuperarEstudiantesPorGenero(StudentService sv, String gender) {
        var students = sv
                .findByGender(gender).stream().map(s -> String.format("%s %s - (%s)",
                        s.getFirstName(), s.getLastName(), s.getDocumentNumber()))
                .collect(Collectors.joining(" *** "));
        log.info("Estudiantes de género {}: {}", gender, students);
    }

    /**
     * b.6) recuperar las carreras con estudiantes inscriptos, y ordenar por cantidad de inscriptos.
     */

     public static void carrerasInscriptosOrdenada(CareerService cs){
            var results = cs.findCareersWithStudentCount();

            log.info(results.toString());
     }

    /**
     * b.7) recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia
     */
    public static void recuperarEstudiantesPorCarreraYCiudad(StudentService sv, long careerId, String city) {
        var students = sv
                .findByCareerAndCity(careerId, city).stream().map(s -> String.format("%s %s - (%s)",
                        s.getFirstName(), s.getLastName(), s.getDocumentNumber()))
                .collect(Collectors.joining(" *** "));
        log.info("Estudiantes de la carrera {} que viven en {}: {}", careerId, city, students);
    }
}