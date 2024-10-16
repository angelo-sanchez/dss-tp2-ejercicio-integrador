package edu.unicen.tp2.repositories;

import edu.unicen.tp2.schema.Career;
import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.schema.StudentCareer;
import edu.unicen.tp2.schema.StudentCareerId;

public interface StudentCareerRepository extends BaseRepository<StudentCareer, StudentCareerId> {
    StudentCareer save(Student student, Career career);
}
