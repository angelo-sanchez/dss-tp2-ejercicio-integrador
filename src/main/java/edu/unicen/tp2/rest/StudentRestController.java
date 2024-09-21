package edu.unicen.tp2.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unicen.tp2.schema.Student;
import edu.unicen.tp2.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentRestController {
    private StudentService studentService;

    StudentRestController(StudentService studentService) {
        // Agregamos las dependencias por constructor
        this.studentService = studentService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Student addStudents(@RequestBody Map<String, String> student) {
        String fn = student.get("firstName");
        String ln = student.get("lastName");
        int age = Integer.parseInt(student.get("age"));
        String dn = student.get("documentNumber");
        String ubn = student.get("universityBookNumber");
        String gender = student.get("gender");
        String city = student.get("cityOfResidence");

        return studentService.createStudent(fn, ln, age, dn, ubn, gender, city);
    }
}
