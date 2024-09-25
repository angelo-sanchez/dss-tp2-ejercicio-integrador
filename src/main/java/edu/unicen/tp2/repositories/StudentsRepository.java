package edu.unicen.tp2.repositories;

import java.util.List;

import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.schema.StudentCareer;

public interface StudentsRepository {
    public List<Student> findAllOrderBy(String fieldName);
    public List<Student> findAllByGender(String gender);
    public Student findById(long id);
    public Student findOneByUniversityBookNumber(String universityBookNumber);
    public Student save(Student student);
    public StudentCareer saveStudentCareer(StudentCareer studentCareer);
}
