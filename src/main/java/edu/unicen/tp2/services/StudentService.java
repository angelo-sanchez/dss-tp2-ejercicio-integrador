package edu.unicen.tp2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unicen.tp2.repository.CarreerRepository;
import edu.unicen.tp2.repository.StudentsRepository;
import edu.unicen.tp2.schema.Career;
import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.schema.StudentCareer;
import edu.unicen.tp2.schema.StudentCareerId;
import edu.unicen.tp2.validation.ValidatorFactory;

@Service
public class StudentService {
    
    private StudentsRepository studentRepository;

    @Autowired
    private CarreerRepository carreerRepository;

    public StudentService(StudentsRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(String firstName, String lastName, int age, String documentNumber,
            String universityBookNumber, String gender, String cityOfResidence) {
        if (!ValidatorFactory.getValidator("gender").isValid(gender)) {
            throw new IllegalArgumentException("El género no es válido");
        }

        var student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);
        student.setDocumentNumber(documentNumber);
        student.setUniversityBookNumber(universityBookNumber);
        student.setGender(gender);
        student.setCityOfResidence(cityOfResidence);
        return studentRepository.save(student);
    }

    public List<Student> getStudents(String orderBy) {
        if(!ValidatorFactory.getValidator("studentAttribute").isValid(orderBy)) {
            throw new IllegalArgumentException("No se puede ordenar por el atributo " + orderBy);
        }
        return studentRepository.findAllOrderBy(orderBy);
    }

    public StudentCareer addStudentToCareer(long studentId, long careerId){
        
        var studentCareer = new StudentCareer();

        Career career = carreerRepository.findById(careerId)
        .orElseThrow(() -> new IllegalArgumentException("Carrera invalida"));

        Student student = studentRepository.findById(studentId);

        if(student == null) {
            throw new IllegalArgumentException("Estudiante invalido");
        }

        var studentCarerId = new StudentCareerId();

        studentCarerId.setCareerId(careerId);
        studentCarerId.setStudentId(studentId);
        
        studentCareer.setId(studentCarerId);
        studentCareer.setCareer(career);
        studentCareer.setStudent(student);

        studentCareer.setGraduated(false);
        studentCareer.setYearsEnrolled(0);

        studentRepository.saveStudentCareer(studentCareer);

        return studentCareer;


        
    }

}
