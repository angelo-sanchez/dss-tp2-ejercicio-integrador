package edu.unicen.tp2.services;

import java.util.List;
import edu.unicen.tp2.repositories.StudentsRepository;
import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.validation.ValidatorFactory;

public class StudentService {
    private StudentsRepository studentRepository;

    public StudentService(StudentsRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(String firstName, String lastName, int age, String documentNumber,
            String universityBookNumber, String gender, String cityOfResidence) {
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
        if (!ValidatorFactory.getValidator("studentAttribute").isValid(orderBy)) {
            throw new IllegalArgumentException("No se puede ordenar por el atributo " + orderBy);
        }
        return studentRepository.findAllOrderBy(orderBy);
    }
}
