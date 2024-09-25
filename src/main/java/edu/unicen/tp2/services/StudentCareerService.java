package edu.unicen.tp2.services;

import edu.unicen.tp2.repositories.CareerRepository;
import edu.unicen.tp2.repositories.StudentsRepository;
import edu.unicen.tp2.schema.Career;
import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.schema.StudentCareer;
import edu.unicen.tp2.schema.StudentCareerId;

public class StudentCareerService {

    private StudentsRepository studentsRepository;
    private CareerRepository careerRepository;
    

    public StudentCareerService(StudentsRepository studentsRepository, CareerRepository careerRepository) {
        this.studentsRepository = studentsRepository;
        this.careerRepository = careerRepository;
    }


    public StudentCareer addStudentToCareer(long studentId, long careerId){
        
        var studentCareer = new StudentCareer();

        Career career = careerRepository.findById(careerId);

        if(career == null){
            throw new IllegalArgumentException("Carrera invalida");
        }

        Student student = studentsRepository.findById(studentId);

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

        studentsRepository.saveStudentCareer(studentCareer);

        return studentCareer;
   
    }
}
