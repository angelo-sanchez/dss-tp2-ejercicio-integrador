package edu.unicen.tp2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.unicen.tp2.repository.StudentsRepository;
import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.validation.ValidatorFactory;

@Service
public class StudentService {
    private StudentsRepository studentRepository;

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

    public List<Student> getStudents() {
        return studentRepository.findAllOrderBy("documentNumber");
    }

}
