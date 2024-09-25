package edu.unicen.tp2.services;

import edu.unicen.tp2.repositories.CareerRepository;
import edu.unicen.tp2.repositories.StudentCareerRepository;
import edu.unicen.tp2.repositories.StudentsRepository;
import edu.unicen.tp2.schema.Career;
import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.schema.StudentCareer;
import edu.unicen.tp2.schema.StudentCareerId;

public class StudentCareerService {

    private StudentsRepository studentsRepository;
    private CareerRepository careerRepository;
    private StudentCareerRepository studentCareerRepository;
    

    public StudentCareerService(StudentsRepository studentsRepository, CareerRepository careerRepository, StudentCareerRepository studentCareerRepository) {
        this.studentsRepository = studentsRepository;
        this.careerRepository = careerRepository;
        this.studentCareerRepository = studentCareerRepository;
    }


    public StudentCareer addStudentToCareer(long studentId, long careerId){
        
        Career career = careerRepository.findById(careerId);

        if(career == null){
            throw new IllegalArgumentException("Carrera invalida");
        }

        Student student = studentsRepository.findById(studentId);

        if(student == null) {
            throw new IllegalArgumentException("Estudiante invalido");
        }

        return studentCareerRepository.save(student, career);
        
   
    }
}
