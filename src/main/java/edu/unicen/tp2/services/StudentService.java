package edu.unicen.tp2.services;

import edu.unicen.tp2.repositories.CareerRepository;
import edu.unicen.tp2.repositories.StudentsRepository;
import edu.unicen.tp2.schema.Career;
import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.schema.StudentCareer;
import edu.unicen.tp2.schema.StudentCareerId;

public class StudentService {
    private StudentsRepository studentRepository;
    private CareerRepository careerRepository;

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


}
