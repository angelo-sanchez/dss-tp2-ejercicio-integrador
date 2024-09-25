package edu.unicen.tp2.repositories;

import edu.unicen.tp2.schema.Career;
import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.schema.StudentCareer;

public interface StudentCareerRepository {
    StudentCareer save(Student student, Career career);
}
