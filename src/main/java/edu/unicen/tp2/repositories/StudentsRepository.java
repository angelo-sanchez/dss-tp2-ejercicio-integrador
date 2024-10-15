package edu.unicen.tp2.repositories;

import java.util.List;

import edu.unicen.tp2.schema.Student;

public interface StudentsRepository extends BaseRepository<Student, Long> {
    List<Student> findAllOrderBy(String fieldName);
    List<Student> findAllByGender(String gender);
    List<Student> findAllByCareerAndCity(Long careerId, String city);
    Student findOneByUniversityBookNumber(String universityBookNumber);
}
